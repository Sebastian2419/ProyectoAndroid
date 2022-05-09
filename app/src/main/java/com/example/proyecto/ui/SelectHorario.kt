package com.example.proyecto.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R
import com.example.proyecto.adapter.HorarioAdapter
import com.example.proyecto.databinding.SelectHorarioFragmentBinding
import com.example.proyecto.model.Boleto
import com.example.proyecto.model.ListHorario



class SelectHorario : Fragment() {

    //Binding para fragmento con view model
    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: SelectHorarioFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SelectHorarioFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var numboletos = 0
       viewModel.getPeliculaSelect.observe(viewLifecycleOwner, Observer {
           binding.imageView.setImageResource(it.img)

           binding.namepelicula.setText(it.nombre)
            //SE LLENA EL LIST VIEW DE HORARIO
           binding.lvHorario.adapter = object : HorarioAdapter(view.context, R.layout.cardhorario, it.listhorario ){
               override fun seleccionarHorario(seleccion: ListHorario) {

                   val compra = Boleto(it,seleccion, numboletos )
                   viewModel.setcompra(compra)
                   findNavController().navigate(R.id.action_navigation_horario_to_navigation_ticket)
               }

           }
       })


        //Calculo de la compra
        binding.masboletos.setOnClickListener{
            numboletos++

            val precio = numboletos * 80
            binding.cantboleto.text = numboletos.toString()
            binding.precioboleto.text = "$ ${precio}"
        }


    }


}