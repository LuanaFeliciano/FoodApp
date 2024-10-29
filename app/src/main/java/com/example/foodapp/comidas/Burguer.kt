package com.example.foodapp.comidas

data class Burguer(
    val tamanho: String,
    override val preco: Double,
    override val imagemUrl: String,
) : Comida {
    override fun descricao(): String {
        return "Burguer, tamanho: $tamanho"
    }
}