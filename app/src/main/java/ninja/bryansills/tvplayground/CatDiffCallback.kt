package ninja.bryansills.tvplayground

import androidx.leanback.widget.DiffCallback

class CatDiffCallback : DiffCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}
