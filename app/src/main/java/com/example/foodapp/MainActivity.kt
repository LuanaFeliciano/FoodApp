package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.foodapp.comidas.Comida
import com.example.foodapp.comidas.ComidaFactory
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaDeComidas()
                }
            }
        }
    }
}

@Composable
fun ListaDeComidas() {
    Column( modifier = Modifier
        .padding(WindowInsets.statusBars.asPaddingValues())
        .padding(10.dp)) {
        Text(
            text = "Lista de Comidas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp, start = 10.dp)
        )

        LazyColumn {
            items(montarComidas()) { meal ->
                ComidaCard(meal = meal)
            }
        }
    }
}

@Composable
fun ComidaCard(meal: Comida) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .heightIn(max = 140.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp)
                    .clip(MaterialTheme.shapes.medium)
            ) {
                AsyncImage(
                    model = meal.imagemUrl,
                    contentDescription = "meal-image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = meal.descricao(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black
                )
                Text(
                    text = "Preço: R$ ${meal.preco}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}



fun montarComidas(): List<Comida> = listOf(
    ComidaFactory.criarComida(
        "pastel",
        "G",
        "carne",
        5.0,
        "https://th.bing.com/th/id/OIP.sHs7d9hQJi0RgVlrNgwDsgHaE8?rs=1&pid=ImgDetMain"
    ),
    ComidaFactory.criarComida(
        tipo = "burguer",
        tamanho = "P",
        recheio = null,
        preco = 10.0,
        "https://centralfrutas.com.br/wp-content/uploads/2021/04/lanches.jpg"
    )
)