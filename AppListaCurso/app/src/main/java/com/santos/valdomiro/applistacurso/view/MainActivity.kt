package com.santos.valdomiro.applistacurso.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.santos.valdomiro.applistacurso.controller.CursoController
import com.santos.valdomiro.applistacurso.controller.PessoaController
import com.santos.valdomiro.applistacurso.databinding.ActivityMainBinding
import com.santos.valdomiro.applistacurso.databinding.ActivitySpinnerBinding
import com.santos.valdomiro.applistacurso.model.Curso
import com.santos.valdomiro.applistacurso.model.Pessoa

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerBinding

    private lateinit var spinner: Spinner

    private lateinit var editPrimeiroNome: EditText
    private lateinit var editSobrenome: EditText
    private lateinit var editCursoDesejado: EditText
    private lateinit var editTelefoneContato: EditText

    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button
    private lateinit var btnFinalizar: Button

    private lateinit var pessoa : Pessoa

    private lateinit var controller: PessoaController
    private lateinit var cursoController: CursoController

    private lateinit var listaDeCursos: List<Curso>
    private lateinit var nomesDosCursos: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarComponentes()

        controller = PessoaController(this)
        cursoController = CursoController()
        listaDeCursos = cursoController.listarCursos()



        nomesDosCursos = cursoController.dadosParaSpinner()

        // Adapter
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cursoController.dadosParaSpinner()
        )

        // Layout
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)

        // Injetar o Adapter ao Spinner - A lista sera gerada
        spinner.adapter = adapter




        for (curso in listaDeCursos) {
            Log.d("log", "onCreate: ${curso.nomeCurso}")
        }

        for (nome in cursoController.dadosParaSpinner()) {
            Log.d("log", "nomesDeCursos: $nome")
        }

        for (nome in nomesDosCursos) {
            Log.d("log", "nomesDeCursos_outra_vez: $nome")
        }

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

        spinner = binding.spinner
    }

}