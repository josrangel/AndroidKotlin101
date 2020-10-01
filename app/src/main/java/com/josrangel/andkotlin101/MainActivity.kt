package com.josrangel.andkotlin101

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //val sharedPreferences: SharedPreferences = getSharedPreferences("NAATPREF", Context.MODE_PRIVATE);
    val sharedPreferences: SharedPreferences by lazy{
        getSharedPreferences("NAATPREF", Context.MODE_PRIVATE);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //automaticamente hace el findViewById
        btnAdd?.setOnClickListener{
            //Toast.makeText(this,"Click ADD",Toast.LENGTH_SHORT).show()
            val word:String? = editWord?.text?.toString()
            saveData(word)
            showData()

        }
        showAllData()

    }

    override fun onPause() {
        super.onPause()
        saveAllData()
    }

    private fun showData(){
        val recoverWord: String? = sharedPreferences.getString("WORD",null) ?: ""
        txtRespuesta?.append("\n$recoverWord")
    }

    private fun showAllData(){
        val recoverWord: String? = sharedPreferences.getString("ALLWORD",null) ?: ""
        txtRespuesta?.append("\n$recoverWord")
    }

    private fun saveData(word: String?){
        //sharedPreferences.edit().putString("WORD",word).apply()

        sharedPreferences.edit(commit = false) {
            putString("WORD",word)
        }
    }

    private fun saveAllData(){
        //sharedPreferences.edit().putString("WORD",word).apply()
        val recoverWord: String? = txtRespuesta?.text?.toString()

        sharedPreferences.edit(commit = false){
            putString("ALLWORD",recoverWord)
        }
    }
}

