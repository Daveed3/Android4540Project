package com.example.gantt


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentViewTaskBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class ViewTaskFragment : Fragment() {

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("tasks")
    val TAG = "In-Progress Tasks"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentViewTaskBinding>(
            inflater,
            R.layout.fragment_view_task, container, false

        )
        // Read from the database
        // https://firebase.google.com/docs/database/web/read-and-write
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                Log.d(TAG, "Value is: $value")
                    binding.taskItem.text = value
        }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })
        //TODO: add functionality for remembering changes
        binding.taskCheckbox.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_viewTaskFragment_to_completedTaskFragment)
        }

        //TODO: add functionality for loading the right view item task
        binding.taskItem.setOnClickListener { view: View ->


            view.findNavController().navigate(R.id.action_viewTaskFragment_to_viewTaskItemFragment)
        }

        //TODO: add functionality for creating a new task
        binding.addTaskButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_viewTaskFragment_to_viewTaskItemFragment)
        }

        return binding.root
    }


}
