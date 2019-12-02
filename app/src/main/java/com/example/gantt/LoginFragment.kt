package com.example.gantt


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*

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
        val email = binding.emailEdittextRegister.text.toString()
        val password = binding.passwordEdittextRegister.text.toString()

        Log.d ("login", "Nickname" + binding.nameEdittextRegister)
        Log.d("Login", "Email is:" + email)
        Log.d("Login", "Password:" + password)

        println("nickname"+ binding.nameEdittextRegister.text.toString())

        //Todo: firebase authentication to create user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!it.isSuccessful) return@addOnCompleteListener

            //else if successful
            Log.d("Login", "Login Sucess, Email is: + ${it.result?.user?.uid}")

        }

        return binding.root
    }


}
