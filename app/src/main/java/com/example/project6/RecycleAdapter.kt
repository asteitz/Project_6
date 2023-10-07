package com.example.project6

import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(private val itemsList : ArrayList<ItemDetails>) : RecyclerView.Adapter<AddProjectAdapter.AddProjectViewHolder>() {
    inner class AddProjectViewHolder(private val binding : AddProjectItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ItemDetails){
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddProjectViewHolder{
        return AddProjectViewHolder(AddProjectItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AddProjectViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size
}
