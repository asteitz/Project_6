    import android.view.LayoutInflater
    import android.view.ViewGroup
    import androidx.recyclerview.widget.ListAdapter
    import androidx.recyclerview.widget.RecyclerView
    import com.example.project6.Note
    import com.example.project6.NoteDiffItemCallback
    import com.example.project6.databinding.RvLayoutBinding
    class NotesAdapter (val clickListener: (noteId: Long) -> Unit,
                          val deleteClickListener: (noteId: Long) -> Unit)
        : ListAdapter<Note, NotesAdapter.NoteItemViewHolder>(NoteDiffItemCallback()) {
        /**
         * The notesAdapter  allows us to communicate between two interfaces taht ae not compatible,
         * in our case this is the view and the database by binding them to commnicate.
         * This allows us to access the commands to the database in the ModelView.
         *
         * @param clickListener listening for if the note is pressed
         * @param deleteClickListener listening for the action of the delete button being pressed
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : NoteItemViewHolder = NoteItemViewHolder.inflateFrom(parent)
        override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item, clickListener, deleteClickListener)
        }


        class NoteItemViewHolder(val binding: RvLayoutBinding)
            : RecyclerView.ViewHolder(binding.root) {

            companion object {
                // inflates the values from the NoteItem's viewholder
                fun inflateFrom(parent: ViewGroup): NoteItemViewHolder {
                    val layoutInflater = LayoutInflater.from(parent.context)
                    val binding = RvLayoutBinding.inflate(layoutInflater, parent, false)
                    return NoteItemViewHolder(binding)
                }
            }

            // binds the values together
            fun bind(item: Note, clickListener: (noteId: Long) -> Unit,
                     deleteClickListener: (noteId: Long) -> Unit) {
                binding.note = item
                binding.root.setOnClickListener { item.noteId?.let { it1 -> clickListener(it1) } }
                binding.xButton.setOnClickListener{ item.noteId?.let { it1 ->
                    deleteClickListener(
                        it1
                    )
                } }
            }
        }
    }