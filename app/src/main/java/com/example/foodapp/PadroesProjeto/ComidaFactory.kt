package com.example.foodapp.PadroesProjeto

import com.example.foodapp.comidas.Comida
import com.example.foodapp.comidas.tipoComida.Burguer
import com.example.foodapp.comidas.tipoComida.Pastel

object ComidaFactory {
    fun criarComida(tipo: String, recheio: String, preco: Double, Imagem:String): Comida {
        return when (tipo.lowercase()) {
            "pastel" ->
                Pastel(
                    recheio,
                    preco,
                    Imagem
                )
            "burguer" ->
                Burguer(
                    recheio,
                    preco,
                    Imagem
                )
            else -> throw IllegalArgumentException(
                "Esse tipo de comida não existe no cardápio"
            )
        }
    }
}