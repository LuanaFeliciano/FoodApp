package com.example.foodapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.foodapp.PadroesProjeto.OpcoesExtrasSingleton
import com.example.foodapp.comidas.Comida
import com.example.foodapp.PadroesProjeto.ComidaDecorator

@Composable
fun DetalhesComidaModal(meal: Comida, onDismiss: () -> Unit, adicinarNoCarrinho: () -> Unit) {
    var comidaAtual by remember { mutableStateOf(meal) }


    // Opcoes extras
    val opcoesExtras = OpcoesExtrasSingleton.CriarOpcoes()

    Dialog(onDismissRequest = { onDismiss() }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFF5F5F5),
            modifier = Modifier.padding(16.dp),
            shadowElevation = 8.dp
        ) {
            Column(modifier = Modifier.padding(20.dp)) {

                Text(
                    text = comidaAtual.descricao(),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = "Preço: R$ ${comidaAtual.preco}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Adicionar Opção de Molho e Bebida:",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                opcoesExtras.forEach { opcao ->
                    Button(
                        onClick = {
                            comidaAtual = ComidaDecorator(comidaAtual, opcao.nome, opcao.preco)
                            opcao.qtde += 1
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text("${opcao.nome} (+R$ ${opcao.preco}) x${opcao.qtde}")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { onDismiss() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Fechar")
                    }

                    Button(
                        onClick = {
                            adicinarNoCarrinho()
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Quero esse!")
                    }
                }
            }
        }
    }
}

