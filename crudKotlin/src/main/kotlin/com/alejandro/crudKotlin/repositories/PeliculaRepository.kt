package com.alejandro.crudKotlin.repositories

import com.alejandro.crudKotlin.entities.Pelicula
import org.springframework.data.jpa.repository.JpaRepository

interface PeliculaRepository : JpaRepository<Pelicula, Long> {

}