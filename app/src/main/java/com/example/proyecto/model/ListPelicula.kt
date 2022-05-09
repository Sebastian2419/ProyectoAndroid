package com.example.proyecto.model

data class ListPelicula(
    val nombre:String ,
    val categoria:String,
    val img:Int,
    val descripcion:String,
    val listhorario:ArrayList<ListHorario>){

}
