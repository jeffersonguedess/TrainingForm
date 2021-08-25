package br.trainingForme.com.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.trainingForme.com.R
import br.trainingForme.com.model.Users

class MyAdapter(private val usersList: ArrayList<Users>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item_aluno,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = usersList[position]

        holder.nome.text = currentitem.nome
        holder.telefone.text = currentitem.telefone.toString()
    }

    override fun getItemCount(): Int {
        return usersList.size
     }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nome: TextView = itemView.findViewById(R.id.txt_nome)
        val telefone: TextView = itemView.findViewById(R.id.txt_telefone)
    }
}