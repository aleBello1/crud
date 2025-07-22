package com.alejandro.crudKotlin.utils

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.validation.BindingResult

@Component
class UtilValidation {

    // Método para validar y devolver errores en formato JSON
    fun validation(result: BindingResult): ResponseEntity<*> {
        val errors = mutableMapOf<String, String>()

        result.fieldErrors.forEach { e ->
            errors[e.field] = "El campo ${e.field} ${e.defaultMessage}"
        }

        return ResponseEntity.badRequest().body(errors)
    }

}