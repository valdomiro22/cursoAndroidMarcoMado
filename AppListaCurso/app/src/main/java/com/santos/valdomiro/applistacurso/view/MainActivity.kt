package com.santos.valdomiro.applistacurso.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.santos.valdomiro.applistacurso.databinding.ActivityMainBinding
import com.santos.valdomiro.applistacurso.model.Pessoa

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var pessoa : Pessoa

    private lateinit var editPrimeiroNome: EditText
    private lateinit var editSobrenome: EditText
    private lateinit var editCursoDesejado: EditText
    private lateinit var editTelefoneContato: EditText

    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button
    private lateinit var btnFinalizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarComponentes()

        pessoa = Pessoa(
            "Valdomiro",
            "Santos",
            "Kotlin",
            "(16) 9 8475-1459")

        binding.editPrimeiroNome.setText(pessoa.primeiroNome)
        binding.editSobrenome.setText(pessoa.sobrenome)
        binding.editCursoDesejado.setText(pessoa.cursoDesejado)
        binding.editContato.setText(pessoa.telefoneContato)

         btnLimpar.setOnClickListener {
            limparCampos()
        }

        btnFinalizar.setOnClickListener {
            finish()
        }

        btnSalvar.setOnClickListener {
            criarNovaPessoa()
        }
    }

    private fun limparCampos() {
        binding.editPrimeiroNome.setText("")
        binding.editSobrenome.setText("")
        binding.editCursoDesejado.setText("")
        binding.editContato.setText("")

//        binding.editPrimeiroNome.hint = ""
//        binding.editSobrenome.hint = ""
//        binding.editCursoDesejado.hint = ""
//        binding.editContato.hint = ""

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

    private fun inicializarComponentes() {
        editPrimeiroNome = binding.editPrimeiroNome
        editSobrenome = binding.editSobrenome
        editCursoDesejado = binding.editCursoDesejado
        editTelefoneContato = binding.editContato

        btnLimpar = binding.btnLimpar
        btnSalvar = binding.btnSalvar
        btnFinalizar = binding.btnFinalizar

    }

}