package com.estia.neighbors.fragments.adapters

import com.estia.neighbors.fragments.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
}
