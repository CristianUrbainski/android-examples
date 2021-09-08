package br.com.urbainski.android.compose.example.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.urbainski.android.compose.example.R
import br.com.urbainski.android.compose.example.data.Jogador

@Composable
fun ImageJogadorView(jogador: Jogador, size: Dp = 40.dp) {
    Image(
        painter = painterResource(jogador.idProfileImage),
        contentDescription = null,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
    )
}

@Composable
fun NomeEmailJogadorView(jogador: Jogador, textAlign: TextAlign = TextAlign.Start) {
    Column {
        Surface {
            Text(
                text = jogador.name,
                modifier = Modifier.fillMaxWidth(),
                textAlign = textAlign
            )
        }

        Surface {
            Text(
                text = jogador.email,
                modifier = Modifier.fillMaxWidth(),
                textAlign = textAlign,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun CarreiraJogadorView(jogador: Jogador, textAlign: TextAlign = TextAlign.End) {
    val anoCarreiraFim =
        if (jogador.anoCarreiraFim == 0) stringResource(R.string.atual) else jogador.anoCarreiraFim
    Column {
        Surface {
            Text(
                text = stringResource(
                    R.string.carreira_dois_pontos_inicio_traco_fim,
                    jogador.anoCarreiraInicio,
                    anoCarreiraFim
                ),
                modifier = Modifier.fillMaxSize(),
                textAlign = textAlign,
                fontSize = 10.sp
            )
        }
    }
}