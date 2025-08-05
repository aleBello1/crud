package com.alejandro.crudKotlin.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.*

import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/html")
class HtmlController() {

    @PostMapping("/upload-html")
    fun uploadHtmlFile(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        try {
            // Verificar que el archivo no esté vacío
            if (file.isEmpty) {
                return ResponseEntity.badRequest().body("Por favor, sube un archivo que no esté vacío")
            }

            // verifica que el archivo sea html
            val isHtmlFile = file.originalFilename?.let {
                it.endsWith(".html", ignoreCase = true)
            } ?: false

            if (!isHtmlFile) {
                return ResponseEntity.badRequest().body("Solo se permiten archivos HTML")
            }

            // Guardar el archivo en el sistema de archivos
//            val uploadDir = Paths.get("uploads")
//            if (!Files.exists(uploadDir)) {
//                Files.createDirectories(uploadDir)
//            }
//
//            val filePath = uploadDir.resolve(file.originalFilename!!)
//            file.transferTo(filePath.toFile())

            return ResponseEntity.ok("Archivo subido exitosamente: ${file.originalFilename}")
        } catch (e: Exception) {
            return ResponseEntity.internalServerError().body("Error al subir el archivo: ${e.message}")
        }
    }

}