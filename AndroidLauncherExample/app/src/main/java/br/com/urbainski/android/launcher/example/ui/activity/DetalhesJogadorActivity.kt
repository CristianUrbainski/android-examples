package br.com.urbainski.android.launcher.example.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.urbainski.android.launcher.example.R
import br.com.urbainski.android.launcher.example.databinding.ActivityDetalhesJogadorBinding
import br.com.urbainski.android.launcher.example.model.Jogador
import br.com.urbainski.android.launcher.example.util.ConverterUtils

class DetalhesJogadorActivity : AppCompatActivity(), DetalhesJogadorActivityEventListener {
    private lateinit var binding: ActivityDetalhesJogadorBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalhes_jogador)
        binding.listener = this

        if (intent.hasExtra("jogador")) {

            intent.getParcelableExtra<Jogador>("jogador").let {
                binding.jogador = it
                binding.anoCarreiraFim = ConverterUtils.converterAnoFimCarreira(this, it!!)
            }
        }

        supportActionBar?.title = getString(R.string.detalhes_jogador)
    }

    override fun onBackPressed() {
        setResult(RESULT_CANCELED)
        super.onBackPressed()
    }

    override fun onVotar() {
        val intent = Intent().apply {
            putExtra(RESULT_KEY, binding.ratingBar.rating)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        const val JOGADOR_PARAM_KEY = "jogador"
        const val RESULT_KEY = "result"
    }
}

class DetalhesJogadorActivityContract : ActivityResultContract<Jogador, Float?>() {
    override fun createIntent(context: Context, input: Jogador?): Intent {
        return Intent(context, DetalhesJogadorActivity::class.java).apply {
            putExtra(DetalhesJogadorActivity.JOGADOR_PARAM_KEY, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Float? {
        return if (resultCode == Activity.RESULT_OK) intent?.getFloatExtra(
            DetalhesJogadorActivity.RESULT_KEY,
            0.0f
        ) else null
    }
}

interface DetalhesJogadorActivityEventListener {
    fun onVotar()
}