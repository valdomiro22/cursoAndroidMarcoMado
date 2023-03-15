package com.santos.valdomiro.applistacurso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.santos.valdomiro.applistacurso.databinding.ActivityMainBinding
import com.santos.valdomiro.applistacurso.model.Pessoa

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var pessoa : Pessoa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pessoa = Pessoa(
            "Valdomiro",
            "Santos",
            "Kotlin",
            "(16) 9 8475-1459")

        binding.editPrimeiroNome.setText(pessoa.primeiroNome)
        binding.editSobrenome.setText(pessoa.sobrenome)
        binding.editCursoDesejado.setText(pessoa.cursoDesejado)
        binding.editContato.setText(pessoa.telefoneContato)

        binding.btnLimpar.setOnClickListener {
            limparCampos()
        }

        binding.btnFinalizar.setOnClickListener {
            finish()
        }

        binding.btnSalvar.setOnClickListener {
            criarNovaPessoa()
        }
    }

    private fun limparCampos() {
        binding.editPrimeiroNome.setText("")
        binding.editSobrenome.setText("")
        binding.editCursoDesejado.setText("")
        binding.editContato.setText("")

        binding.editPrimeiroNome.hint = ""
        binding.editSobrenome.hint = ""
        binding.editCursoDesejado.hint = ""
        binding.editContato.hint = ""
    }

    private fun criarNovaPessoa() {
        val primeiroNome = binding.editPrimeiroNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val curso = binding.editCursoDesejado.text.toString()
        val telContato = binding.editContato.text.toString()

        val pessoa2 = Pessoa(primeiroNome, sobrenome, curso, telContato)

        Log.d("log", "criarNovaPessoa: \n" +
                "${pessoa2.primeiroNome} \n" +
                "${pessoa2.sobrenome} \n" +
                "${pessoa2.cursoDesejado} \n" +
                "${pessoa2.telefoneContato} ")
    }

}