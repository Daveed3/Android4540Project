package com.example.gantt


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)

        //TODO: add functionality for login checking and loading database
        binding.loginButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_ganttFragment)
        }

        return binding.root
    }


}
