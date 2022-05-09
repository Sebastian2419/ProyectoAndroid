package com.example.proyecto.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.proyecto.R
import com.example.proyecto.model.Boleto



class TicketAdapter(val context: Context,
                    val layout:Int,
                    val lista:ArrayList<Boleto>):
    BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myview = inflater.inflate(layout, null)

        val img = myview.findViewById<ImageView>(R.id.imagenPelicula)
        val nombre = myview.findViewById<TextView>(R.id.funcion)
        val horario= myview.findViewById<TextView>(R.id.hora)
        val numasientos = myview.findViewById<TextView>(R.id.cantboleto)
        val precioTotal = myview.findViewById<TextView>(R.id.cantTotal)

        img.setImageResource(lista[position].listPelicula.img)
        nombre.text = lista[position].listPelicula.nombre
        horario.text = "${lista[position].listHorario.hora} - ${lista[position].listHorario.fecha}"
        numasientos.text = "${lista[position].numBoletos}"
        precioTotal.text = "${lista[position].numBoletos * 80}"

        return myview
    }
}