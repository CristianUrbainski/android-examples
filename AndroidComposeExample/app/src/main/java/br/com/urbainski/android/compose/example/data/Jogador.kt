package br.com.urbainski.android.compose.example.data

import br.com.urbainski.android.compose.example.R

data class Jogador(
    val name: String,
    val email: String,
    val anoCarreiraInicio: Int,
    val anoCarreiraFim: Int,
    val idProfileImage: Int = R.drawable.profile_picture,
)