package com.example.rvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: ConstraintLayout
    private lateinit var EnterField: EditText
    private lateinit var Enterbtn: Button
    private lateinit var messages: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)
        messages = ArrayList()

        rvMessages.adapter = MessageAdapter(this, messages)
        rvMessages.layoutManager = LinearLayoutManager(this)

        EnterField = findViewById(R.id.Enterfeild)
        Enterbtn = findViewById(R.id.Enterbtn)

        Enterbtn.setOnClickListener { addMessage() }
    }

    private fun addMessage(){
        val msg = EnterField.text.toString()
        if(msg.isNotEmpty()){
            messages.add(msg)
            EnterField.text.clear()
            EnterField.clearFocus()
        }else{
            Snackbar.make(rvMain, "Please do not leave it empty.", Snackbar.LENGTH_LONG).show()
        }
    }
}
