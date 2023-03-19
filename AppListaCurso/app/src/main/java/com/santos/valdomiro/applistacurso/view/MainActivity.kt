package com.santos.valdomiro.applistacurso.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.santos.valdomiro.applistacurso.controller.PessoaController
import com.santos.valdomiro.applistacurso.databinding.ActivityMainBinding
import com.santos.valdomiro.applistacurso.model.Pessoa

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var editPrimeiroNome: EditText
    private lateinit var editSobrenome: EditText
    private lateinit var editCursoDesejado: EditText
    private lateinit var editTelefoneContato: EditText

    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button
    private lateinit var btnFinalizar: Button

    private lateinit var pessoa : Pessoa
    private lateinit var controller: PessoaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarComponentes()

        controller = PessoaController(this)

        btnSalvar.setOnClickListener {
            controller.salvar(criarNovaPessoa())
        }

        btnLimpar.setOnClickListener {
            limparCamposESharedPreferences()
        }

        btnFinalizar.setOnClickListener {
            finish()
        }
    }

    private fun limparCamposESharedPreferences() {
        editPrimeiroNome.setText("")
        editSobrenome.setText("")
        editCursoDesejado.setText("")
        editTelefoneContato.setText("")

        controller.limpar()

    }

    private fun criarNovaPessoa(): Pessoa {

        val primeiroNome = binding.editPrimeiroNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val cursoDesejado = binding.editCursoDesejado.text.toString()
        val telefoneContato = binding.editContato.text.toString()

        pessoa = Pessoa(primeiroNome, sobrenome, cursoDesejado, telefoneContato)

        Log.d("log", "criarNovaPessoa: \n" +
                "${pessoa.primeiroNome} \n" +
                "${pessoa.sobrenome} \n" +
                "${pessoa.cursoDesejado} \n" +
                "${pessoa.telefoneContato} ")

        return pessoa
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