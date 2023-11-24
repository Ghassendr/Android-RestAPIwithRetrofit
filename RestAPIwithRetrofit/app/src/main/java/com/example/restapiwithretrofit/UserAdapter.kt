package com.example.restapiwithretrofit

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
class UserAdapter(private val data: ArrayList<offre>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val textViewCode: TextView = itemView.findViewById(R.id.textViewCode)
        val textViewIntitule: TextView = itemView.findViewById(R.id.textViewIntitule)
        val textViewSpecialite: TextView = itemView.findViewById(R.id.textViewSpecialite)
        val textViewSociete: TextView = itemView.findViewById(R.id.textViewSociete)
        val textViewPays: TextView = itemView.findViewById(R.id.textViewPays)
        val textViewNbPostes: TextView = itemView.findViewById(R.id.textViewNbPostes)
        val card: CardView = itemView.findViewById(R.id.card)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                selectedPosition = position
                notifyDataSetChanged()
                // Vous pouvez également implémenter ici la logique pour traiter le clic sur un élément
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.ligne, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = data[position]

        holder.textViewCode.text = "Code: ${currentItem.code ?: "N/A"}"
        holder.textViewIntitule.text = "Intitule: ${currentItem.intitule ?: "N/A"}"
        holder.textViewSpecialite.text = "Specialite: ${currentItem.specialite ?: "N/A"}"
        holder.textViewSociete.text = "Societe: ${currentItem.societe ?: "N/A"}"
        holder.textViewPays.text = "Pays: ${currentItem.pays ?: "N/A"}"
        holder.textViewNbPostes.text = "NbPostes: ${currentItem.nbpostes ?: "N/A"}"

        if (position == selectedPosition) {
            holder.card.setBackgroundColor(Color.RED)
        } else {
            holder.card.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getSelectedItem(): Int {
        return selectedPosition
    }
}
