package com.example.foodapp.PadroesProjeto

import com.example.foodapp.comidas.Comida

class ComidaDecorator(
    private val comidaBase: Comida,
    private val opcaoExtra: String,
    private val precoOpcao: Double
) : Comida {
    override val preco: Double
        get() = comidaBase.preco + precoOpcao

    override val imagemUrl: String
        get() = comidaBase.imagemUrl

    override fun descricao(): String {//aqui verifico se ja tem a opcao
        return if (comidaBase.descricao().contains(opcaoExtra)) {
            comidaBase.descricao()
        } else {
            "${comidaBase.descricao()}, $opcaoExtra"
        }
    }
}
