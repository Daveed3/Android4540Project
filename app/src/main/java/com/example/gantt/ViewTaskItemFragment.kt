package com.example.gantt


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentViewTaskItemBinding
import com.google.firebase.database.FirebaseDatabase
/**
 * A simple [Fragment] subclass.
 */
class ViewTaskItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentViewTaskItemBinding>(inflater,
            R.layout.fragment_view_task_item,container,false)

        //TODO: add functionality for saving updates

        binding.finishedButton.setOnClickListener { view : View ->

            val db = FirebaseDatabase.getInstance()
            val myRef = db.reference
            //Set Details into DB
            myRef.child("in_progress").child(binding.taskItemName.text.toString()).child("details").push().key
            myRef.child("in_progress").child(binding.taskItemName.text.toString()).child("details").setValue(binding.taskItemDetails.text.toString())

            //Set Skills Needed into DB
            myRef.child("in_progress").child(binding.taskItemName.text.toString()).child("skills_needed").push().key
            myRef.child("in_progress").child(binding.taskItemName.text.toString()).child("skills_needed").setValue(binding.skillsNeeded.text.toString())

            //Set Files into DB
            myRef.child("in_progress").child(binding.taskItemName.text.toString()).child("files").push().key
            myRef.child("in_progress").child(binding.taskItemName.text.toString()).child("files").setValue(binding.fileDownload.text.toString())


            view.findNavController().navigate(R.id.action_viewTaskItemFragment_to_viewTaskFragment)
        }

        return binding.root
    }


}
