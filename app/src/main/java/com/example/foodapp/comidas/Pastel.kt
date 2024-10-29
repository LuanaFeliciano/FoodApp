package com.example.foodapp.comidas

data class Pastel(
    val recheio: String,
    val tamanho: String,
    override val preco: Double,
    override val imagemUrl: String,
) : Comida {
    override fun descricao(): String {
        return "Pastel de $recheio, tamanho: $tamanho"
    }
}
