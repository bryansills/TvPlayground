package ninja.bryansills.tvplayground

import android.content.Context
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter

class MainAdapter(private val context: Context) : ArrayObjectAdapter(ListRowPresenter()) {
    private var catRow: ListRow? = null
    private var hatRow: ListRow? = null

    fun setCats(cats: List<Cat>) {
        val headerItem = HeaderItem("Cats")
        val adapter = ArrayObjectAdapter(CatPresenter(context))
        adapter.setItems(cats, null)
        catRow = ListRow(headerItem, adapter)
        val listRowList = listOfNotNull(catRow, hatRow)
        setItems(listRowList, null)
    }

    fun setHats(hats: List<Hat>) {
        val headerItem = HeaderItem("Hats")
        val adapter = ArrayObjectAdapter(HatPresenter(context))
        adapter.setItems(hats, null)
        hatRow = ListRow(headerItem, adapter)
        val listRowList = listOfNotNull(catRow, hatRow)
        setItems(listRowList, null)
    }
}
