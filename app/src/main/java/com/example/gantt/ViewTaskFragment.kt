package com.example.gantt


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentViewTaskBinding

class ViewTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentViewTaskBinding>(inflater,
            R.layout.fragment_view_task,container,false)

        //TODO: add functionality for remembering changes
        binding.taskCheckbox.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viewTaskFragment_to_completedTaskFragment)
        }

        //TODO: add functionality for loading the right view item task
        //TODO: figure out why this crashes
        binding.taskItem.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viewTaskFragment_to_viewTaskItemFragment)
        }

        //TODO: add functionality for creating a new task
        //TODO: figure out why this crashes
        binding.addTaskButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_viewTaskFragment_to_viewTaskItemFragment)
        }

        return binding.root
    }


}
