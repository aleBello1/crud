package com.alejandro.crudKotlin.services

import com.alejandro.crudKotlin.entities.Actor
import java.util.Optional

interface ActorService {

    fun findAll(): List<Actor>

    fun findById(id: Long): Optional<Actor>

    fun save(actor: Actor): Actor

    fun update(id: Long, actor: Actor): Optional<Actor>

    fun deleteById(id: Long): Optional<Actor>

}