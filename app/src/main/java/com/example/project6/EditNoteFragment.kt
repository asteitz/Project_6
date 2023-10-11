package com.example.project6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.project6.databinding.FragmentNoteBinding


class EditNoteFragment: Fragment() {
    /***
     * This Class handles the actions taken when a note is clicked or when a user presses the add note button
     */
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        /**
         * The onCreateView function is overridden to take the arguments from the noteId and set the view model
         *
         * @param inflater used to inflate the view model
         * @param container used in the binding containing the view grop
         * @param savedInstanceState holding the previous state of the object to reflect the current behaviors
         *
         * @returns the view
         * */
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        val view = binding.root
        val noteId = EditNoteFragmentArgs.fromBundle(requireArguments()).noteId

        val application = requireNotNull(this.activity).application
        val dao = NotesDatabase.getInstance(application).noteDao

        val viewModelFactory = EditNoteViewModelFactory(noteId, dao)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(EditNoteViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.navigateToList.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                view.findNavController()
                    .navigate(R.id.action_note_to_notes)
                viewModel.onNavigatedToList()

            }
        })
        return view
    }
    override fun onDestroyView() {
        /**
         * used to destory the view
         * @return no return, just destroys the view
         */
        super.onDestroyView()
        _binding = null
    }
}