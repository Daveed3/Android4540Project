package com.example.gantt


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentCompletedTaskBinding
import com.google.firebase.database.FirebaseDatabase

class CompletedTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentCompletedTaskBinding>(inflater,
            R.layout.fragment_completed_task,container,false)

        //TODO: add functionality to register item as complete
        binding.submitCompletionButton.setOnClickListener { view : View ->

            val database = FirebaseDatabase.getInstance()
            val myRef = database.reference
            myRef.child("done").child(binding.dateCompleted.text.toString()).push().key
            myRef.child("done").child(binding.dateCompleted.text.toString()).setValue(binding.notes.text.toString())

            view.findNavController().navigate(R.id.action_completedTaskFragment_to_viewTaskFragment)
        }

        return binding.root

    }
}
