package com.example.proyecto.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.proyecto.R
import com.example.proyecto.adapter.TicketAdapter
import com.example.proyecto.databinding.TicketFragmentBinding


class Ticket : Fragment() {

    //Binding para fragmento
    private var _binding: TicketFragmentBinding? = null
    private val binding get() = _binding!!


    private val viewModel: GlobalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TicketFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getcompra.observe(viewLifecycleOwner, {
            binding.lvBoletos.adapter = TicketAdapter(view.context, R.layout.boleto, it)
        })
    }

}