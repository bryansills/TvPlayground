package ninja.bryansills.tvplayground

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.OnItemViewClickedListener
import kotlin.random.Random

/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : BrowseSupportFragment() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var mainAdapter: MainAdapter

    private val random = Random(System.currentTimeMillis())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = getString(R.string.browse_title)

        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = ContextCompat.getColor(requireContext(), R.color.fastlane_background)
        searchAffordanceColor = ContextCompat.getColor(requireContext(), R.color.search_opaque)

        mainAdapter = MainAdapter(requireContext())
        adapter = mainAdapter

        onItemViewClickedListener =
            OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
                Toast.makeText(activity, "Implement click handler", Toast.LENGTH_SHORT)
                    .show()
            }

        setOnSearchClickedListener {
            val randomNumber = random.nextInt(0, 20)
            if (randomNumber % 7 == 0) {
                viewModel.clearCats()
            } else if (randomNumber % 8 == 0) {
                viewModel.clearHats()
            } else if (randomNumber % 2 == 0) {
                 viewModel.addCat(
                     Cat(
                         "Cool Cat #${randomNumber}",
                         randomNumber,
                         randomNumber % 3 != 0,
                         "Cool Breed #${randomNumber}"
                     )
                 )
            } else {
                viewModel.addHat(
                    Hat(
                        "Cool Hat #${randomNumber}",
                        "BLACK",
                        randomNumber
                    )
                )
            }
            Toast.makeText(
                activity, "Do Search", Toast.LENGTH_SHORT
            )
                .show()
        }

        viewModel.cats.observe(viewLifecycleOwner) { mainAdapter.setCats(it) }
        viewModel.hats.observe(viewLifecycleOwner) { mainAdapter.setHats(it) }
    }
}
