package com.estia.neighbors.fragments.data

import com.estia.neighbors.fragments.data.service.DummyNeighborApiService
import com.estia.neighbors.fragments.data.service.NeighborApiService
import com.estia.neighbors.fragments.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun deleteNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun createNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
