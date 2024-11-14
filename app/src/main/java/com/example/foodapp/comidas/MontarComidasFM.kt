package com.example.foodapp.comidas

import com.example.foodapp.PadroesProjeto.ComidaFactory

fun montarComidas(): List<Comida> = listOf(
    ComidaFactory.criarComida(
        "pastel",
        "Queijo",
        5.0,
        "https://th.bing.com/th/id/OIP.sHs7d9hQJi0RgVlrNgwDsgHaE8?rs=1&pid=ImgDetMain"
    ),
    ComidaFactory.criarComida(
        "pastel",
        "Frango/Catupiry",
        7.0,
        "https://th.bing.com/th/id/OIP.40ppYIj5t9BMCOK6TsZ-OQHaE7?rs=1&pid=ImgDetMain"
    ),
    ComidaFactory.criarComida(
        tipo = "burguer",
        recheio = "X-Frango",
        preco = 10.0,
        "https://centralfrutas.com.br/wp-content/uploads/2021/04/lanches.jpg"
    ),
    ComidaFactory.criarComida(
        tipo = "burguer",
        recheio = "X-Salada",
        preco = 10.0,
        "https://th.bing.com/th/id/OIP.SuXs9bW0jpd7yq5pMUv3UgHaEK?rs=1&pid=ImgDetMain"
    )


)