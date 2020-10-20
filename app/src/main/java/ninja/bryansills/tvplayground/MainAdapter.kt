package ninja.bryansills.tvplayground

import android.content.Context
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter

class MainAdapter(private val context: Context) : ArrayObjectAdapter(ListRowPresenter()) {
    private val catHeaderItem = HeaderItem("Cats")
    private val hatHeaderItem = HeaderItem("Hats")

    private val catAdapter = ArrayObjectAdapter(CatPresenter(context))
    private val hatAdapter = ArrayObjectAdapter(HatPresenter(context))

    private var catRow: ListRow? = null
    private var hatRow: ListRow? = null

    fun setCats(cats: List<Cat>) {
        catAdapter.setItems(cats, CatDiffCallback())
        catRow = ListRow(1L, catHeaderItem, catAdapter)
        val listRowList = listOfNotNull(catRow, hatRow)
        setItems(listRowList, ListRowDiffCallback())
    }

    fun setHats(hats: List<Hat>) {
        hatAdapter.setItems(hats, HatDiffCallback())
        hatRow = ListRow(2L, hatHeaderItem, hatAdapter)
        val listRowList = listOfNotNull(catRow, hatRow)
        setItems(listRowList, ListRowDiffCallback())
    }
}
