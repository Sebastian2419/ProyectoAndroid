package com.example.proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R
import com.example.proyecto.model.ListPelicula




abstract class CarteleraAdapter(val context: Context, val list: ArrayList<ListPelicula>, val res: Int) : RecyclerView.Adapter<CarteleraAdapter.PeliculaVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaVH {
        val vh = PeliculaVH(LayoutInflater.from(context).inflate(res, null))
        return vh
    }

    override fun onBindViewHolder(holder: PeliculaVH, position: Int) {
        val pelicula = list[position]
        holder.bind(pelicula)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PeliculaVH(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pelicula: ListPelicula) {
            val img: ImageView = itemView.findViewById(R.id.imagenPelicula)
            val nombre: TextView = itemView.findViewById(R.id.nombrePelicula)

            img.setImageResource(pelicula.img)
            nombre.text = pelicula.nombre

            img.setOnClickListener {
                Toast.makeText(context, "${pelicula.nombre}", Toast.LENGTH_SHORT).show()
                pullPelicula(pelicula)
            }

        }

    }
    //FUNCION ABSTRACTA, la pelicula se llama a la parte de la cartelera, de esa manera se aplica herencia
    abstract fun pullPelicula(pelicula: ListPelicula)
}