package com.example.gantt


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentGanttBinding

/**
 * A simple [Fragment] subclass.
 */
class GanttFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGanttBinding>(inflater,
            R.layout.fragment_gantt,container,false)

        //TODO: add navigation from calendar day
        binding.button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_ganttFragment_to_viewTaskFragment)
        }

        return binding.root
    }


}
