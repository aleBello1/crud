package com.alejandro.crudKotlin.controllers

import com.alejandro.crudKotlin.entities.Actor
import com.alejandro.crudKotlin.services.ActorService
import com.alejandro.crudKotlin.utils.UtilValidation
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/actores")
class ActorController(
    private val actorService: ActorService,
    private val utilValidation: UtilValidation
) {

    // Obtener todos los actores
    @GetMapping
    fun findAll(): List<Actor> = actorService.findAll()

    // Obtener un actor por ID
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<*> {
        val optionalActor = actorService.findById(id)
        return if (optionalActor.isPresent) {
            ResponseEntity.ok(optionalActor.get())
        } else {
            ResponseEntity.notFound().build<Any>()
        }
    }

    // Guardar un nuevo actor
    @PostMapping
    fun saveActor(
        @Valid @RequestBody actor: Actor,
        result: BindingResult
    ): ResponseEntity<*> {
        if (result.hasFieldErrors()) {
            return utilValidation.validation(result)
        }
        val newActor = actorService.save(actor)
        return ResponseEntity.status(HttpStatus.CREATED).body(newActor)
    }

    // Actualizar un actor existente
    @PutMapping("/{id}")
    fun updateActor(
        @Valid @RequestBody actor: Actor,
        result: BindingResult,
        @PathVariable id: Long
    ): ResponseEntity<*> {
        if (result.hasFieldErrors()) {
            return utilValidation.validation(result)
        }
        val optionalUpdated = actorService.update(id, actor)
        return if (optionalUpdated.isPresent) {
            ResponseEntity.status(HttpStatus.CREATED).body(optionalUpdated.get())
        } else {
            ResponseEntity.notFound().build<Any>()
        }
    }

    // Eliminar un actor por ID
    @DeleteMapping("/{id}")
    fun deleteActor(@PathVariable id: Long): ResponseEntity<*> {
        val optionalDeleted = actorService.deleteById(id)
        return if (optionalDeleted.isPresent) {
            ResponseEntity.ok(optionalDeleted.get())
        } else {
            ResponseEntity.notFound().build<Any>()
        }
    }


}