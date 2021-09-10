package br.com.urbainski.android.launcher.example.model

import android.os.Parcelable
import br.com.urbainski.android.launcher.example.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jogador(
    val name: String,
    val email: String,
    val anoCarreiraInicio: Int,
    val anoCarreiraFim: Int,
    val idProfileImage: Int = R.drawable.profile_picture,
): Parcelable