package br.com.urbainski.android.compose.example.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import br.com.urbainski.android.compose.example.R
import br.com.urbainski.android.compose.example.data.Jogador
import br.com.urbainski.android.compose.example.data.SampleData
import br.com.urbainski.android.compose.example.ui.activity.ui.theme.AndroidComposeExampleTheme
import br.com.urbainski.android.compose.example.ui.component.JogadorDetalhesView
import br.com.urbainski.android.compose.example.ui.component.JogadorListView
import br.com.urbainski.android.compose.example.ui.component.Views
import br.com.urbainski.android.compose.example.util.JsonUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            AndroidComposeExampleTheme {
                Scaffold {
                    NavigationComponent(navController)
                }
            }
        }
    }

    private fun changeTitle(@StringRes id: Int) {

        supportActionBar?.title = getString(id)
    }

    @Composable
    fun NavigationComponent(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Views.JogadorListView.route) {
            composable(
                route = Views.JogadorListView.route
            ) {
                changeTitle(R.string.lista_jogadores)
                JogadorListView(navController, SampleData.jogadores)
            }
            composable(
                route = Views.JogadorDetalhesView.route,
                arguments = listOf(
                    navArgument(Views.JogadorDetalhesView.parameters.first()) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                changeTitle(R.string.detalhes_jogador)
                backStackEntry?.arguments?.getString(Views.JogadorDetalhesView.parameters.first())
                    ?.let { json ->
                        val jogador = JsonUtils.fromJson(json, Jogador::class.java)
                        JogadorDetalhesView(jogador)
                    }
            }
        }
    }

}