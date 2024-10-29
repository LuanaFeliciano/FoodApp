package com.example.foodapp.comidas

interface Comida {
    fun descricao(): String
    val preco: Double
    val imagemUrl: String
}