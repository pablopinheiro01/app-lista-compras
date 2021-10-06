package br.com.supermarket.listacompras.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.supermarket.listacompras.databinding.HomeFragmentBinding
import br.com.supermarket.listacompras.databinding.ItemListaBinding
import br.com.supermarket.listacompras.model.ItemDeCompra

class HomeFragmentAdapter(
    private val context: Context
): ListAdapter<ItemDeCompra, HomeFragmentAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(context)
        val viewBinding = ItemListaBinding.inflate(inflater, parent, false)
        return ViewHolder.from(parent)
//        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    class ViewHolder(private val binding: ItemListaBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        fun bind(
            item: ItemDeCompra
        ){
            binding.nomeItem.text = item.nome
            binding.valorDinheiro.text = item.quantidade.toString()
            binding.quantidadeNumero.text = item.quantidade.toString()

        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemListaBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

object DiffCallback: DiffUtil.ItemCallback<ItemDeCompra>(){
    override fun areItemsTheSame(oldItem: ItemDeCompra, newItem: ItemDeCompra) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: ItemDeCompra, newItem: ItemDeCompra) = oldItem == newItem
}