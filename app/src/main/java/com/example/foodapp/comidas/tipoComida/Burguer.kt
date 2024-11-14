package com.example.foodapp.comidas.tipoComida

import com.example.foodapp.comidas.Comida

data class Burguer(
    val recheio: String,
    override val preco: Double,
    override val imagemUrl: String,
) : Comida {
    override fun descricao(): String {
        return "$recheio do Querino"
    }
}