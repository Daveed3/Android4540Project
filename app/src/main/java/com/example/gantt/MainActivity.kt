package com.example.gantt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
     val TAG = "message"
     val test1 = listOf<String>()

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        LoginFragment loginMenu = new fragment_login()

// Write a message to the database
//        val database = FirebaseDatabase.getInstance()
//        database = FirebaseDatabase.getInstance().reference
//
//        val myRef = database.getReference()
////        Logger.Log (database)
//        println("DATABASE TEST: " + database)
//
////        database.setValue("Hello, World!")

//        database.("https://gantt-63d23.firebaseio.com/").setValue(TAG,"New trainer")
//        database.child(TAG).child("trainer").setValue("name")
//        println("this is a test")

        var database = FirebaseDatabase.getInstance()
        val myRef = database.getReference()
        println("this is the db:" + myRef)
//        myRef.child("test").child("trainer").setValue("2")
        myRef.child("trainer2").setValue("trainer")
        println(myRef.child("test").child("trainer"))



//
//// Read from the database
//        database.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val value = dataSnapshot.getValue(String::class.java)
//                Log.d(TAG, "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException())
//            }
//        })
    }


}
