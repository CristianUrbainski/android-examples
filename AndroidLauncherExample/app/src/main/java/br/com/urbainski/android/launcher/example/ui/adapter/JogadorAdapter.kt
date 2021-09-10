package br.com.urbainski.android.launcher.example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.urbainski.android.launcher.example.R
import br.com.urbainski.android.launcher.example.databinding.AdapterJogadorItemBinding
import br.com.urbainski.android.launcher.example.model.Jogador
import br.com.urbainski.android.launcher.example.util.ConverterUtils

class JogadorAdapter(
    private val jogadores: List<Jogador>,
    private val listener: JogadorAdapterListener
) : RecyclerView.Adapter<JogadorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: AdapterJogadorItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_jogador_item,
            parent,
            false
        )
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jogador = jogadores[position]
        holder.bind(jogador)
    }

    override fun getItemCount(): Int = jogadores.size

    class ViewHolder(
        private val binding: AdapterJogadorItemBinding,
        private val listener: JogadorAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(jogador: Jogador) {
            binding.jogador = jogador
            binding.anoCarreiraFim =
                ConverterUtils.converterAnoFimCarreira(itemView.context, jogador)
            binding.listener = listener
            binding.executePendingBindings()
        }
    }

    interface JogadorAdapterListener {

        fun onSelect(jogador: Jogador)
    }
}