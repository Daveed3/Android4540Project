package com.example.gantt


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gantt.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )

//      TODO: Firebase authentication to create user with email and password
        binding.loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_ganttFragment)

            var email = binding.emailEdittextRegister.text.toString()
            var password = binding.passwordEdittextRegister.text.toString()

            Log.d("Login", "Email is:" + email)
            Log.d("Login", "Password:" + password)

            auth = FirebaseAuth.getInstance()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    val user = auth.currentUser
                    if (!it.isSuccessful) Log.d("Return",return@addOnCompleteListener)
                    //Email needs to be valid
                    //Password needs to be at least 6 characters
                    //To be stored in Authentication

//                    if (it.isSuccessful) {
//                        Log.d("Login","email is: " + email)
//                        Log.d("Login", "Login successful")
//
////                        return@addOnCompleteListener
//                    } else {
//                        Log.d("Login", "Something went wrong")
//                    }
                }
                .addOnFailureListener {
                    Log.d("Main", "Failed to create user: ${it.message}")
                }

        }

        return binding.root
    }


}
