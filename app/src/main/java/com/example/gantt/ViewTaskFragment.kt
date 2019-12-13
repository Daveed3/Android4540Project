package com.example.gantt


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.gantt.databinding.FragmentViewTaskBinding
import com.google.firebase.database.DataSnapshot
import kotlinx.android.synthetic.main.fragment_view_task.*
import kotlinx.android.synthetic.main.fragment_view_task.view.*
import kotlinx.android.synthetic.main.fragment_view_task.view.button_layout

class ViewTaskFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentViewTaskBinding>(
            inflater,
            R.layout.fragment_view_task, container, false
        )

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

////        lateinit var button: Button
////        button = Button(context)
//        Button<context> button = inflater.inflate(R.layout.fragment_view_task, null)
//        binding.layout.addView()
        var list = mutableListOf<Int>(1,2)

//        var buttonLayout = view.findViewById<LinearLayout>(R.id.button_layout)

//        Log.d("message", "Here is " + buttonLayout)
//
//        for (i in list) {
//            var button = Button(context)
//            button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//            button.id = 100 + i
//            button.text = "Button" + i
//            button.setOnClickListener(View.OnClickListener {
//                button.text = "button " + i + " was clicked"
//            })
//            button.setBackgroundColor(Color.GREEN)
//            buttonLayout.addView(button)
//
//        }


        return binding.root
    }


}
