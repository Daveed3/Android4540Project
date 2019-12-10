package com.example.gantt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gantt.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference
        println("this is the db:" + myRef)
//        myRef.child("test").child("trainer").setValue("2")
        myRef.child("trainer2").child("trainer1").setValue("Ash")
    }
}
