    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.ListAdapter
    import androidx.recyclerview.widget.RecyclerView
    import com.example.project6.databinding.NoteItemBinding
    class NotesAdapter (val clickListener: (noteId: Long) -> Unit,
                          val deleteClickListener: (noteId: Long) -> Unit)
        : ListAdapter<Note, NoteItemAdapter.TaskItemViewHolder>(NoteDiffItemCallback()) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)
        override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item, clickListener, deleteClickListener)
        }

        class NoteItemViewHolder(val binding: NoteItemBinding)
            : RecyclerView.ViewHolder(binding.root) {

            companion object {
                fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                    val layoutInflater = LayoutInflater.from(parent.context)
                    val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                    return TaskItemViewHolder(binding)
                }
            }

            fun bind(item: Note, clickListener: (taskId: Long) -> Unit,
                     deleteClickListener: (taskId: Long) -> Unit) {
                binding.task = item
                binding.root.setOnClickListener { clickListener(item.taskId) }
                binding.deleteButton.setOnClickListener { deleteClickListener(item.taskId) }
            }
        }
    }