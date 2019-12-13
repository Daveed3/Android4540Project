package com.example.gantt


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

//    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )

        binding.loginButton.setOnClickListener { view: View ->
            val email = binding.emailEdittextRegister.text.toString()
            val password = binding.passwordEdittextRegister.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener() {
                    view.findNavController().navigate(R.id.action_loginFragment_to_ganttFragment)
                }
        }

        binding.registerButton.setOnClickListener { view: View ->
            val email = binding.emailEdittextRegister.text.toString()
            val password = binding.passwordEdittextRegister.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) Log.d("Return", return@addOnCompleteListener)
                    //TODO: Email needs to be valid
                    //TODO: Password needs to be at least 6 characters
                }
                .addOnFailureListener {
                    Log.d("Login", "Failed to create user: ${it.message}")
                }
            view.findNavController().navigate(R.id.action_loginFragment_to_ganttFragment)
        }
        return binding.root
    }


}
