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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.foodapp.comidas.montarComidas
import com.example.foodapp.comidas.Comida
import com.example.foodapp.components.DetalhesComidaModal
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
    var carrinhoContador by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(
                text = "Cardápio Do Querino",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.width(50.dp))
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Carrinho",
                modifier = Modifier.size(24.dp)
            )
            if (carrinhoContador > 0) {
                Text(
                    text = "$carrinhoContador",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        LazyColumn {
            items(montarComidas()) { meal ->
                ComidaCard(meal = meal) {
                    carrinhoContador++
                }
            }
        }
        Footer()
    }
}

@Composable
fun ComidaCard(meal: Comida, adicionar: () -> Unit) {
    var isModalOpen by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .heightIn(max = 140.dp)
            .clickable { isModalOpen = true },
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
                    .padding(10.dp),
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
    if (isModalOpen) {
        DetalhesComidaModal(meal = meal, onDismiss = { isModalOpen = false }, adicinarNoCarrinho = adicionar)
    }
}


@Composable
fun Footer() {
    Spacer(modifier = Modifier.height(100.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    )  {
        Text(
            text = "Rua da Castellica, 34",
            style = MaterialTheme.typography.titleSmall,
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Faça seu Pedido!",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "(14) 3291-6430",
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}








