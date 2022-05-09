package com.example.proyecto.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto.model.Boleto
import com.example.proyecto.model.ListPelicula


class GlobalViewModel : ViewModel() {
    // se importa la clase pelicula
    //Mutable Live Data
    private val peliculaSelect = MutableLiveData<ListPelicula>()
    //Get del live Data
    val getPeliculaSelect:LiveData<ListPelicula> get() = peliculaSelect
    //Setter del live data
    fun setPeliculaSelect(pelicula: ListPelicula){
        peliculaSelect.value = pelicula
    }




//--------------------------------------COMPRA----------------------------------------------
    private val compras = MutableLiveData<ArrayList<Boleto>>().apply { postValue(ArrayList()) }

    val getcompra:LiveData<ArrayList<Boleto>>get()=compras

    fun setcompra(boletos:Boleto){
        compras.value?.add(boletos)
    }
}