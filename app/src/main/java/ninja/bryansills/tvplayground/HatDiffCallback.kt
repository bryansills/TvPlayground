package ninja.bryansills.tvplayground

import androidx.leanback.widget.DiffCallback

class HatDiffCallback : DiffCallback<Hat>() {
    override fun areItemsTheSame(oldItem: Hat, newItem: Hat): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Hat, newItem: Hat): Boolean {
        return oldItem == newItem
    }
}
