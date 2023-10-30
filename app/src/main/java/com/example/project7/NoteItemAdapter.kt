package com.example.project7
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.project7.databinding.NoteItemBinding

class NoteItemAdapter(val clickListener: (note: Note) -> Unit)
    : ListAdapter<Note, NoteItemAdapter.noteItemViewHolder>(NoteDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : noteItemViewHolder = noteItemViewHolder.inflateFrom(parent)
    override fun onBindViewHolder(holder: noteItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class noteItemViewHolder(val binding: NoteItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): noteItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NoteItemBinding.inflate(layoutInflater, parent, false)
                return noteItemViewHolder(binding)
            }
        }

        fun bind(item: Note, clickListener: (note: Note) -> Unit) {
            binding.note = item
            binding.root.setOnClickListener { clickListener(item) }
        }
    }
}