package com.example.project7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.project7.databinding.FragmentEditNoteBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EditNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditNoteFragment : Fragment() {
    val TAG = "EditNoteFragment"
    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!

    // Moves back to notes fragment
    fun NavigateToNotesFragment(view: View, viewModel: NotesViewModel)
    {
        view.findNavController()
            .navigate(R.id.action_editNoteFragment_to_notesFragment)
        viewModel.onNavigatedToList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        val noteId = EditNoteFragmentArgs.fromBundle(requireArguments()).noteId
        val viewModel : NotesViewModel by activityViewModels()
        viewModel.noteId = noteId
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Listening to navigateToList varible and moves to notes fragment when its value changes
        viewModel.navigateToList.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                NavigateToNotesFragment(view, viewModel)
            }
        })
        fun yesPressed(noteId : String) {
            viewModel.deleteNote(noteId)
            NavigateToNotesFragment(view, viewModel)
        }
        binding.Deletenote.setOnClickListener {
            ConfirmDeleteDialogFragment(noteId,::yesPressed).show(childFragmentManager,
                ConfirmDeleteDialogFragment.TAG)
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}