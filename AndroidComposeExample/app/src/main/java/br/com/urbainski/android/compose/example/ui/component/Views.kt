package br.com.urbainski.android.compose.example.ui.component

sealed class Views(
    val route: String,
    val routWithoutParam: String = route,
    val parameters: List<String> = listOf()
) {

    object JogadorListView : Views(
        route = "list_jogador"
    )

    object JogadorDetalhesView : Views(
        route = "detalhes_jogador/{jogador}",
        routWithoutParam = "detalhes_jogador",
        parameters = listOf("jogador")
    )

    fun withParams(vararg parameters: String):String {
        return buildString {
            append(routWithoutParam)
            parameters.forEach { param ->
                append("/${param}")
            }
        }
    }
}
