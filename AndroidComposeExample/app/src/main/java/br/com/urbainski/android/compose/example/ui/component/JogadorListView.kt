package br.com.urbainski.android.compose.example.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.urbainski.android.compose.example.data.Jogador
import br.com.urbainski.android.compose.example.data.SampleData
import br.com.urbainski.android.compose.example.ui.activity.ui.theme.AndroidComposeExampleTheme
import br.com.urbainski.android.compose.example.util.JsonUtils

@Composable
fun JogadorListView(navController: NavHostController?, jogadores: List<Jogador>) {
    AndroidComposeExampleTheme {
        LazyColumn {
            items(jogadores) { jogador ->
                JogadorListItemView(navController, jogador)
            }
        }
    }
}

@Composable
private fun JogadorListItemView(navController: NavHostController?, jogador: Jogador) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 8.dp)
        .clickable {
            val json = JsonUtils.toJson(jogador)
            val route = Views.JogadorDetalhesView.withParams(json)
            navController?.navigate(route)
        }) {

        Row {
            ImageJogadorView(jogador)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Row(modifier = Modifier.weight(2f)) {
            NomeEmailJogadorView(jogador)
        }

        Row(modifier = Modifier.weight(1f)) {
            CarreiraJogadorView(jogador, TextAlign.End)
        }
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp))
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultJogadorListViewPreview() {
    JogadorListView(null, SampleData.jogadores)
}