package br.com.urbainski.android.launcher.example.util

import android.content.Context
import br.com.urbainski.android.launcher.example.R
import br.com.urbainski.android.launcher.example.model.Jogador

object ConverterUtils {

    fun converterAnoFimCarreira(context: Context, jogador: Jogador): String {

        var anoCarreiraFim = jogador.anoCarreiraFim.toString()

        if (jogador.anoCarreiraFim == 0) {

            anoCarreiraFim = context.getString(R.string.atual)
        }

        return anoCarreiraFim;
    }
}