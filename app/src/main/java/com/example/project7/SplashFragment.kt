package com.example.project7
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {

    val viewModel : NotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        val currentUser = viewModel.getCurrentUser()

        val handler = Handler(Looper.myLooper()!!)

        handler.postDelayed({
            if (currentUser != null) {
                viewModel.initializeTheDatabaseReference()
                this.findNavController().navigate(R.id.action_splashFragment_to_notesFragment)
            }
            else {
                this.findNavController().navigate(R.id.action_splashFragment_to_signInFragment)

            }

        }, 2000)
    }


}