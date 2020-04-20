package com.example.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.covid_19.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ingresarB.setOnClickListener { ingresar() }
        binding.covid19B.setOnClickListener { covid19() }
        binding.sintomasB.setOnClickListener { sintomas() }
        binding.indicacionB.setOnClickListener { indicaciones() }

    }
    private fun covid19() {
        val intent = Intent(this, virus::class.java)
        startActivity(intent)

    }

    private fun sintomas() {
        val intent = Intent(this, sintomas::class.java)
        startActivity(intent)

    }

    private fun indicaciones() {
        val intent = Intent(this, indicaciones::class.java)
        startActivity(intent)

    }


    private fun ingresar() {

        val edad = binding.edad.text.toString().toInt()


        when {
            edad in 10..39 -> {
                binding.resultadoText.text = "La tasa de mortalidad por el rango de 10-19 años es 0.2%, por tanto usted no corre riesgo. "
            }
            edad in 40..49 -> {
                binding.resultadoText.text = "La tasa de mortalidad por el rango de 40-49 años es 0.4%, por tanto usted no corre riesgo significativamente. "
            }
            edad in 50..59 -> {
                binding.resultadoText.text = "La tasa de mortalidad por el rango de 50-59 años es 1.3%, a partir de este rango de edad usted corre un riesgo alto. "
            }
            edad in 60..69 -> {
                binding.resultadoText.text = "La tasa de mortalidad por el rango de 60-69 años es 3.6%, a partir de esta rango de edad usted corre un riesgo alto. "
            }
            edad in 70..79 -> {
                binding.resultadoText.text = "La tasa de mortalidad por el rango de 70-79 años es 8.0%, a partir de esta rango de edad usted corre un riesgo significativamente alto. Por favor no salga de su casa. "
            }
            else -> {
                binding.resultadoText.text = "La tasa de mortalidad por el rango de 80+ años es 14.8%, por tanto lo mas probable es que muera :( "
            }
        }
    }
}
