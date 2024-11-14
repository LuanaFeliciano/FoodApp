package com.example.foodapp.PadroesProjeto

import com.example.foodapp.comidas.OpcaoExtra

object OpcoesExtrasSingleton {

    fun CriarOpcoes(): List<OpcaoExtra> {
        return listOf(
            OpcaoExtra("Molho de Alho", 1.5, 0),
            OpcaoExtra("Molho Barbecue", 2.0, 0),
            OpcaoExtra("Molho de Cheddar", 2.5, 0),
            OpcaoExtra("Coca Gelada", 5.0, 0),
            OpcaoExtra("Suco Laranja", 4.5, 0),
        )
    }
}