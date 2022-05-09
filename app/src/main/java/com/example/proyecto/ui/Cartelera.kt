package com.example.proyecto.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyecto.R
import com.example.proyecto.adapter.CarteleraAdapter
import com.example.proyecto.databinding.CarteleraFragmentBinding
import com.example.proyecto.model.ListHorario
import com.example.proyecto.model.ListPelicula


class Cartelera : Fragment() {

    //Binding para fragmento
    private var _binding: CarteleraFragmentBinding? = null
    private val binding get() = _binding!!


    private val viewModel: GlobalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CarteleraFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

        val horariopelicula = ArrayList<ListHorario>()
        horariopelicula.add(ListHorario("12:00","15 May 2022"))
        horariopelicula.add(ListHorario("13:00","15 May 2022"))
        horariopelicula.add(ListHorario("14:00","15 May 2022"))
        horariopelicula.add(ListHorario("15:00","16 May 2022"))
        horariopelicula.add(ListHorario("16:00","16 May 2022"))
        horariopelicula.add(ListHorario("17:00","16 May 2022"))
        horariopelicula.add(ListHorario("18:00","17 May 2022"))


        val listpelis = ArrayList<ListPelicula>()
        listpelis.add(ListPelicula("12 horas para sobrevivir.", "A",R.drawable._2_horas_para_sobrevivir,"Descripcion", horariopelicula ))
        listpelis.add(ListPelicula("Birds of prey.", "A",R.drawable.birds_of_prey,"Descripcion",horariopelicula ))
        listpelis.add(ListPelicula("Fragmentado.", "A",
            R.drawable.fragmentado,"Descripcion", horariopelicula))
        listpelis.add(ListPelicula("Godzilla vs Kong.", "A",R.drawable.godzilla_vs_kong,"Descripcion", horariopelicula ))
        listpelis.add(ListPelicula("Joker.", "A",R.drawable.joker,"Descripcion", horariopelicula ))
        listpelis.add(ListPelicula("Scooby.", "A",R.drawable.scooby,"Descripcion", horariopelicula ))
        listpelis.add(ListPelicula("Sonic.", "A",R.drawable.sonic,"Descripcion", horariopelicula ))

        //RECICLER
        binding.rvCartelera.adapter = object : CarteleraAdapter(view.context, listpelis, R.layout.pelicula_cardview){
            override fun pullPelicula(pelicula: ListPelicula) {
                //Comunicacion entre fragmentos,
                //asignamos la pelicula al view model
                viewModel.setPeliculaSelect(pelicula)
                //navegacion entre fragmentos
                findNavController().navigate(R.id.action_navigation_cartelera_to_navigation_horario)
            }

        }
        //Para hacer un tipo grid, con filas y columnas. RV SE PORTA COMO UN GRID
        binding.rvCartelera.layoutManager = GridLayoutManager(view.context,3)

    }


}