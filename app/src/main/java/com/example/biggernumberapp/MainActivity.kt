package com.example.biggernumberapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.biggernumberapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var obj : ActivityMainBinding // empty object creation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        obj = ActivityMainBinding.inflate(layoutInflater)   // populate object
        setContentView(obj.root)    // set screen as object root
        this.showResult()
    }

    private fun showResult() {
        obj.leftButton.setOnClickListener {
            val num1 = obj.leftButton.text.toString().toInt()
            val num2 = obj.rightButton.text.toString().toInt()

            if (num1 > num2) {
                // SHOW TOAST
                Toast.makeText(this,"You won", Toast.LENGTH_SHORT).show()
                // CHANGE BACKGROUND COLOR
                obj.BackgoundView.setBackgroundColor(Color.GREEN)
            } else {
                // SHOW TOAST
                Toast.makeText(this, "You suck bro! Try again!"
                        +"TIP: PICK THE BIGGER NUMBER!", Toast.LENGTH_SHORT).show()
                // CHANGE BACKGROUND COLOR
                obj.BackgoundView.setBackgroundColor(Color.RED)
            }
            changeNumbers()
        }

        obj.rightButton.setOnClickListener {
            val num1 = obj.leftButton.text.toString().toInt()
            val num2 = obj.rightButton.text.toString().toInt()

            if (num1 < num2) {
                // SHOW TOAST
                Toast.makeText(this,"You won", Toast.LENGTH_SHORT).show()
                // CHANGE BACKGROUND COLOR
                obj.BackgoundView.setBackgroundColor(Color.GREEN)
            } else {
                // SHOW TOAST
                Toast.makeText(this, "You suck bro! Try again!"
                        +"TIP: PICK THE BIGGER NUMBER!", Toast.LENGTH_SHORT).show()
                // CHANGE BACKGROUND COLOR
                obj.BackgoundView.setBackgroundColor(Color.RED)
            }
            changeNumbers()
        }
    }

    private fun changeNumbers() {
        obj.leftButton.text = (0..100).random().toString()
        obj.rightButton.text = (0..100).random().toString()

        if (obj.leftButton.text==obj.rightButton.text){
            changeNumbers()
        }
    }

}