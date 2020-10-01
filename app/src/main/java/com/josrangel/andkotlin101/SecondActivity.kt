package com.josrangel.andkotlin101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent?.extras?.apply {
            val allWords = getString(KEY_ALLWORD)
            txtAllWords?.text = allWords
        } ?: run{
            finish()
            Toast.makeText(this,"No Hay info para mostrar",Toast.LENGTH_SHORT).show()
        }

    }

    companion object{
        const val KEY_ALLWORD = "ALLWORDS"
    }
}