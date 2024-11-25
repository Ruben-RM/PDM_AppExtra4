package com.example.appextra4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var et_nombre:EditText
    private var nombre:String = ""
    private lateinit var btn_nav2calculator:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents()
    {
        et_nombre = findViewById(R.id.etNombre)
        btn_nav2calculator = findViewById(R.id.btn_nav2calculator)
    }

    private fun initListeners()
    {
        btn_nav2calculator.setOnClickListener()
        {
            nombre = et_nombre.text.toString()
            if(nombre == "")
                Toast.makeText(this, "Introduce tu nombre, por favor", Toast.LENGTH_SHORT).show()
            else
                nav2Calulator()
        }
    }

    private fun nav2Calulator()
    {
        var intentCA = Intent(this, CalculatorActivity::class.java)
        intentCA.putExtra("NOMBRE", nombre)
        startActivity(intentCA)
    }
}