package com.santos.valdomiro.applistacurso.view

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.santos.valdomiro.applistacurso.databinding.ActivityMainBinding
import com.santos.valdomiro.applistacurso.model.Pessoa
import java.util.prefs.AbstractPreferences

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

    private lateinit var preferences: SharedPreferences

    val PREFERENCES_NAME: String = "pre_app_lista_vip"

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

//        binding.editPrimeiroNome.setText(pessoa.primeiroNome)
//        binding.editSobrenome.setText(pessoa.sobrenome)
//        binding.editCursoDesejado.setText(pessoa.cursoDesejado)
//        binding.editContato.setText(pessoa.telefoneContato)

        salvarNoSharedPreferences()

         btnLimpar.setOnClickListener {
            limparCampos()
        }

        btnFinalizar.setOnClickListener {
            finish()
        }

        btnSalvar.setOnClickListener {
            criarNovaPessoa()
        }

        recuperarDoSharedPreferences()
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

    @SuppressLint("CommitPrefEdits")
    private fun salvarNoSharedPreferences() {
        preferences = getSharedPreferences(PREFERENCES_NAME, 0)
        val listaVip: SharedPreferences.Editor = preferences.edit()

        listaVip.putString("primeiro_nome", pessoa.primeiroNome)
        listaVip.putString("sobrenome", pessoa.sobrenome)
        listaVip.putString("curso_desejado", pessoa.cursoDesejado)
        listaVip.putString("tel_contato", pessoa.telefoneContato)
        listaVip.apply()

    }

    @SuppressLint("CommitPrefEdits")
    private fun recuperarDoSharedPreferences() {
        preferences = getSharedPreferences(PREFERENCES_NAME, 0)

        val primeiroNome = preferences.getString("primeiro_nome", "vazio")!!
        val sobrenome = preferences.getString("sobrenome", "vazio")!!
        val cursoDesejado = preferences.getString("curso_desejado", "vazio")!!
        val telContato = preferences.getString("tel_contato", "vazio")!!

        val pessoa2: Pessoa = Pessoa(primeiroNome, sobrenome, cursoDesejado, telContato)

        editPrimeiroNome.setText(pessoa2.primeiroNome)
        editSobrenome.setText(pessoa2.sobrenome)
        editCursoDesejado.setText(pessoa2.cursoDesejado)
        editTelefoneContato.setText(pessoa2.telefoneContato)
    }




}