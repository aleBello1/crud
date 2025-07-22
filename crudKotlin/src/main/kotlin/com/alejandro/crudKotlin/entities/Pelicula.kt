package com.alejandro.crudKotlin.entities

import jakarta.persistence.Column
import java.time.LocalDate

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Entity
@Table(name = "peliculas")
data class Pelicula(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    val id: Long = 0,

    @NotBlank
    var titulo: String,

    @Positive
    var duracionMin: Int,

    var fechaEstreno: LocalDate,

    @ManyToMany
    @JoinTable(
        name = "pelicula_actor",
        joinColumns = [JoinColumn(name = "id_pelicula")],
        inverseJoinColumns = [JoinColumn(name = "id_actor")]
    )
    var actores: MutableList<Actor> = mutableListOf()

)