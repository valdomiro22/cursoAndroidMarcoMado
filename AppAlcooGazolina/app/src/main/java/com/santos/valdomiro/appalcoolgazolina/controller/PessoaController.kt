package com.santos.valdomiro.appalcoolgazolina.controller

import android.content.SharedPreferences
import com.santos.valdomiro.appalcoolgazolina.model.Pessoa
import com.santos.valdomiro.appalcoolgazolina.view.MainActivity

class PessoaController() {

    private val preferencesName: String = "pre_app_lista_vip"
    private lateinit var listaVip: SharedPreferences.Editor

    private lateinit var preferences: SharedPreferences

    constructor(mainActivity: MainActivity) : this() {
        preferences = mainActivity.getSharedPreferences(preferencesName, 0)
        listaVip = preferences.edit()
    }

    fun criarSharedPreferences() {

    }

    fun salvar(pessoa: Pessoa) {
        listaVip.putString("primeiro_nome", pessoa.primeiroNome)
        listaVip.putString("sobrenome", pessoa.sobrenome)
        listaVip.putString("curso_desejado", pessoa.cursoDesejado)
        listaVip.putString("tel_contato", pessoa.telefoneContato)
        listaVip.apply()
    }

    fun buscar(pessoa: Pessoa) {

    }

    fun limpar() {
        listaVip.clear()
        listaVip.apply()
    }

}