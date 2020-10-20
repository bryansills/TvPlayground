package ninja.bryansills.tvplayground

import androidx.leanback.widget.DiffCallback
import androidx.leanback.widget.ListRow
import androidx.recyclerview.widget.DiffUtil

class ListRowDiffCallback : DiffCallback<ListRow>() {
    override fun areItemsTheSame(p0: ListRow, p1: ListRow): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: ListRow, p1: ListRow): Boolean {
        val areItemsTheSame = areItemsTheSame(p0, p1)
        val areAdapterItemsTheSameSize = p0.adapter.size() == p1.adapter.size()

        return if (areItemsTheSame && areAdapterItemsTheSameSize) {
            (0..p0.adapter.size()).toList().all { index ->
                return p0.adapter.get(index) == p1.adapter.get(index)
            }
        } else {
            false
        }
    }
}
