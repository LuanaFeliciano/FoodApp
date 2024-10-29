package com.example.foodapp.comidas

object ComidaFactory {
    fun criarComida(tipo: String, tamanho: String, recheio: String? = null, preco: Double, Imagem:String): Comida {
        return when (tipo.lowercase()) {
            "pastel" -> Pastel(recheio ?: "Queijo", tamanho, preco, Imagem)
            "burguer" -> Burguer(tamanho, preco, Imagem)
            else -> throw IllegalArgumentException("Tipo de comida desconhecido")
        }
    }
}