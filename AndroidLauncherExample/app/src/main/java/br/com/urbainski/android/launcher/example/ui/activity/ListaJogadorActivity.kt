package br.com.urbainski.android.launcher.example.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.urbainski.android.launcher.example.R
import br.com.urbainski.android.launcher.example.databinding.ActivityListaJogadorBinding
import br.com.urbainski.android.launcher.example.model.Jogador
import br.com.urbainski.android.launcher.example.model.SampleData
import br.com.urbainski.android.launcher.example.ui.adapter.JogadorAdapter

class ListaJogadorActivity : AppCompatActivity() {
    private val registerActivityDetalhesJogador = registerForActivityResult(
        DetalhesJogadorActivityContract()
    ) { result ->
        if (result != null) {
            Toast.makeText(
                this,
                getString(R.string.value_estrelas_exclamacao, result),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityListaJogadorBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_lista_jogador)

        configurarRecyclerView(binding)

        supportActionBar?.title = getString(R.string.lista_jogadores)
    }

    private fun configurarRecyclerView(binding: ActivityListaJogadorBinding) {

        val listener = object : JogadorAdapter.JogadorAdapterListener {
            override fun onSelect(jogador: Jogador) = openDetalhesJogador(jogador)
        }
        val adapter = JogadorAdapter(SampleData.jogadores, listener)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        )
    }

    private fun openDetalhesJogador(jogador: Jogador) {
        registerActivityDetalhesJogador.launch(jogador)
    }
}