package com.alejandro.crudKotlin.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

import jakarta.validation.constraints.*

@Entity
@Table(name = "actores")
data class Actor (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    val id: Long = 0,

    @field:NotBlank
    // @NotBlank
    var nombre: String = "",

    @field:Positive
    var edad: Int,

)
