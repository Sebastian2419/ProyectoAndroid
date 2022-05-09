package com.example.proyecto.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.proyecto.R
import com.example.proyecto.model.ListHorario


abstract class HorarioAdapter(val context: Context, val layout:Int, val lista : ArrayList<ListHorario>):
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

        val hora = myview.findViewById<TextView>(R.id.horario)
        val fecha = myview.findViewById<TextView>(R.id.fecha)
        val item = myview.findViewById<CardView>(R.id.item)

        hora.text = lista[position].hora
        fecha.text = lista[position].fecha

        item.setOnClickListener {
            val selecccionarhorario = ListHorario(lista[position].fecha, lista[position].hora)
            seleccionarHorario(selecccionarhorario)

        }
        return myview
    }

    abstract fun seleccionarHorario(seleccion :ListHorario)
}