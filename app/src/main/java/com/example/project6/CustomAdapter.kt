package com.example.project6
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Notes(val note: String, val noteBody: Boolean) {
    companion object {
        private var firstNote = 0
        fun createNotesList(numNotes: Int): ArrayList<Notes> {
            val mListOfNotes = ArrayList<Notes>()
            for (i in 1..numNotes) {
                mListOfNotes.add(Notes("Person " + ++firstNote, i <= numNotes / 2))
            }
            return mListOfNotes
        }
    }
}
class CustomAdapter(private val mListOfNotes: List<Notes>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
       // i think needs to be a view group
        val imageView: ImageView = itemView.findViewById(R.id.xButton)
        val textView: TextView = itemView.findViewById(R.id.rvNotes)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        /**
         * constructor and member variables
         * Usually involves inflating a layout from XML and returning the holder
         *
         * @param ViewGroup a view group
         * @param viewType integer to determine view
         * @return view holder
         */
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.rv_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: CustomAdapter.ViewHolder, position: Int) {
        /**
         * constructor and member variables
         * Usually involves inflating a layout from XML and returning the holder
         *
         * @param viewHolders the view we are using
         * @param position position in the array to add to the button
         * @return binds the holder
         */
        // Get the data model based on position
        val note: Notes = mListOfNotes.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.textView
        textView.setText(note.note)
        val button = viewHolder.imageView
    }

        // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mListOfNotes.size
    }
    }