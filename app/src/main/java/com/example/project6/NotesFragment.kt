package com.example.project6

import NotesAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project6.databinding.FragmentNotesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
// need to merge with the main activity


/**
 * A simple [Fragment] subclass.
 * Use the [NotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesFragment : Fragment() {
    val TAG = "NotesFragment"
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val view = binding.root
        val application = requireNotNull(this.activity).application
        val dao = NotesDatabase.getInstance(application).noteDao
        val viewModelFactory = NotesViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(NotesViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        fun noteClicked (noteId : Long) {
            viewModel.onNoteClicked(noteId)
        }
        fun yesPressed(noteId : Long) {
            Log.d(TAG, "in yesPressed(): noteId = $noteId")
            viewModel.deleteNote(noteId)
        }
        fun deleteClicked (taskId : Long) {
            DeleteDialog(taskId,::yesPressed).show(childFragmentManager,
                DeleteDialog.TAG)
        }
        val adapter = NotesAdapter(::noteClicked,::deleteClicked)

        binding.notesList.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        viewModel.navigateToTask.observe(viewLifecycleOwner, Observer { taskId ->
            taskId?.let {
                val action = NotesFragmentDirections
                    .actionNotesToNote(taskId)
                this.findNavController().navigate(action)
                viewModel.onNoteNavigated()
            }
        })

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}