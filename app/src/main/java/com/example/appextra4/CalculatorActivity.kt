package com.example.appextra4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider
import kotlin.random.Random

class CalculatorActivity : AppCompatActivity() {

    private lateinit var tv_nombre:TextView
    private var nombre:String = ""
    private lateinit var btn_1:Button
    private lateinit var btn_2:Button
    private lateinit var btn_3:Button
    private lateinit var btn_4:Button
    private lateinit var btn_5:Button
    private lateinit var btn_6:Button
    private var boton_pulsado:Int = 1
    private lateinit var rs_numCaras:RangeSlider
    private var num_caras:Int = 6
    private lateinit var tv_numCaras:TextView
    private lateinit var btn_rollDice:CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)

        initComponents()
        initListeners()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents()
    {
        tv_nombre = findViewById(R.id.tv_nombre)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        rs_numCaras = findViewById(R.id.rs_numCaras)
        tv_numCaras = findViewById(R.id.tv_numCaras)
        btn_rollDice = findViewById(R.id.btn_rollDice)
    }

    private fun initListeners()
    {
        btn_1.setOnClickListener()
        {
            boton_pulsado = 1
            setBackgroundsBotones()
            setNombre()
        }
        btn_2.setOnClickListener()
        {
            boton_pulsado = 2
            setBackgroundsBotones()
            setNombre()
        }
        btn_3.setOnClickListener()
        {
            boton_pulsado = 3
            setBackgroundsBotones()
            setNombre()
        }
        btn_4.setOnClickListener()
        {
            boton_pulsado = 4
            setBackgroundsBotones()
            setNombre()
        }
        btn_5.setOnClickListener()
        {
            boton_pulsado = 5
            setBackgroundsBotones()
            setNombre()
        }
        btn_6.setOnClickListener()
        {
            boton_pulsado = 6
            setBackgroundsBotones()
            setNombre()
        }

        rs_numCaras.addOnChangeListener()
        { _, value: Float, _ ->
            num_caras = value.toInt()
            setTVNumCaras()
        }

        btn_rollDice.setOnClickListener()
        {
            val numRandom = Random.nextInt(1, num_caras + 1)
            Toast.makeText(this, "Número: " + numRandom.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initUI()
    {
        nombre = intent.extras?.getString("NOMBRE")?:""

        setNombre()
    }

    private fun setBackgroundsBotones()
    {
        when(boton_pulsado)
        {
            1 -> {
                btn_1.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo_oscuro))
                setBackgroundsAmarillos(btn_2, btn_3, btn_4, btn_5, btn_6)
            }
            2 -> {
                btn_2.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo_oscuro))
                setBackgroundsAmarillos(btn_1, btn_3, btn_4, btn_5, btn_6)
            }
            3 -> {
                btn_3.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo_oscuro))
                setBackgroundsAmarillos(btn_1, btn_2, btn_4, btn_5, btn_6)
            }
            4 -> {
                btn_4.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo_oscuro))
                setBackgroundsAmarillos(btn_1, btn_2, btn_3, btn_5, btn_6)
            }
            5 -> {
                btn_5.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo_oscuro))
                setBackgroundsAmarillos(btn_1, btn_2, btn_3, btn_4, btn_6)
            }
            6 -> {
                btn_6.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo_oscuro))
                setBackgroundsAmarillos(btn_1, btn_2, btn_3, btn_4, btn_5)
            }
        }
    }

    private fun setBackgroundsAmarillos(btn_1:Button, btn_2:Button, btn_3:Button, btn_4:Button, btn_5:Button)
    {
        btn_1.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo))
        btn_2.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo))
        btn_3.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo))
        btn_4.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo))
        btn_5.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo))
    }

    private fun setNombre()
    {
        tv_nombre.text = nombre + ": " + boton_pulsado.toString()
    }

    private fun setTVNumCaras()
    {
        tv_numCaras.text = "Numero de caras: " + num_caras.toString()
    }
}