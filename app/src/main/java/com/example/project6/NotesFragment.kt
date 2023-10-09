package com.example.project6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project6.databinding.FragmentNotesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [NotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var navGraph: NavGraph
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        binding.addNoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_notes_to_note)
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}