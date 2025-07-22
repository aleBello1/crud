package com.alejandro.crudKotlin.repositories

import com.alejandro.crudKotlin.entities.Actor
import org.springframework.data.jpa.repository.JpaRepository

interface ActorRepository : JpaRepository<Actor, Long> {

}
