package com.estia.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anas.s.neighbors.R
import com.estia.neighbors.fragments.adapters.ListNeighborHandler
import com.estia.neighbors.fragments.adapters.ListNeighborsAdapter
import com.estia.neighbors.fragments.data.NeighborRepository
import com.estia.neighbors.fragments.models.Neighbor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbour: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        (activity as? NavigationListener)?.updateTitle(R.string.liste_neighbor_toolbar_name)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        addNeighbour = view.findViewById(R.id.ajouter)
        addNeighbour.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh()
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        val alert = AlertDialog.Builder(context)
        alert.setTitle("Confirmation")
            .setMessage("Do you want to delete this user?")

        alert.setPositiveButton(android.R.string.ok) { dialog, _ ->
            NeighborRepository.getInstance().deleteNeighbour(neighbor)
            refresh()
        }

        alert.setNegativeButton(android.R.string.cancel) { dialog, _ ->
            Toast.makeText(
                context,
                android.R.string.cancel, Toast.LENGTH_SHORT
            ).show()
        }
        alert.create().show()
    }
    private fun refresh() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
