package com.santos.valdomiro.appalcoolgazolina.controller

import com.santos.valdomiro.appalcoolgazolina.model.Curso

class CursoController {

    private var listaDeCursos = mutableListOf<Curso>()

    fun listarCursos(): List<Curso> {
        listaDeCursos.add(Curso("Java"))
        listaDeCursos.add(Curso("Kotlin"))
        listaDeCursos.add(Curso("C++"))
        listaDeCursos.add(Curso("Python"))
        listaDeCursos.add(Curso("C#"))
        listaDeCursos.add(Curso("HTML"))
        listaDeCursos.add(Curso("CSS"))

        return listaDeCursos

    }

    fun dadosParaSpinner(): ArrayList<String> {
        val dados = ArrayList<String>()

        for (curso in listaDeCursos) {
            dados.add(curso.nomeCurso)
        }

        return dados
    }
}