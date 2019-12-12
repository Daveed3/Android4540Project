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
            view.findNavController().navigate(R.id.action_viewTaskItemFragment_to_viewTaskFragment)
        }

        return binding.root
    }


}
