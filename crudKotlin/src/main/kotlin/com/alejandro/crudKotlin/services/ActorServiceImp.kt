package com.alejandro.crudKotlin.services

import com.alejandro.crudKotlin.entities.Actor
import com.alejandro.crudKotlin.repositories.ActorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class ActorServiceImpl(
    private val repository: ActorRepository
) : ActorService {

    // Listar todos los actores
    @Transactional(readOnly = true)
    override fun findAll(): List<Actor> {
        return repository.findAll()
    }

    // Obtener un actor por ID
    @Transactional(readOnly = true)
    override fun findById(id: Long): Optional<Actor> {
        return repository.findById(id)
    }

    // Guardar un nuevo actor
    @Transactional
    override fun save(actor: Actor): Actor {
        return repository.save(actor)
    }

    // Actualizar un actor existente
    @Transactional
    override fun update(id: Long, actor: Actor): Optional<Actor> {
        val optionalActor = repository.findById(id)

        if (optionalActor.isPresent) {
            val actorDb = optionalActor.get()
            actorDb.nombre = actor.nombre
            actorDb.edad = actor.edad

            return Optional.of(repository.save(actorDb))
        }

        return optionalActor
    }

    // Eliminar actor por ID
    @Transactional
    override fun deleteById(id: Long): Optional<Actor> {
        val optionalActor = repository.findById(id)

        optionalActor.ifPresent {
            repository.deleteById(id)
        }

        return optionalActor
    }

}