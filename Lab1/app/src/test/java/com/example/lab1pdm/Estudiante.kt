package com.example.lab1pdm

import org.junit.Test

data class Estudiante(
    val nombre:String,
    val carnet: String,
    val asignatura: String
)

class TestEstudiante{
    @Test
    fun pasandoLista(){
        val Ciclo01 = listOf(
            Estudiante("Fernanfloo", "21045", "PDM"),  //PDM = Programación de Dispositivos Móviles
            Estudiante("Luzu", "19830", "AN"),         //AN = Análisis numérico
            Estudiante("Spreen", "22001", "PDM"),
            Estudiante("Carrera", "22005", "AN"),
            Estudiante("Angie Velasco", "21500", "PDM"),
            Estudiante("Rivers", "20999", "AN"),
            Estudiante("ElMariana", "21444", "AN")
        )

        val losDeMoviles = Ciclo01.filter { it.asignatura =="PDM" }
        println()
        println("Lista de estudiantes de PDM:")
        losDeMoviles.forEach {
            println("Nombre: ${it.nombre} - Carnet: ${it.carnet}")
        }
        println()
        val total =losDeMoviles.size
        println("En total hay $total estudiantes en esta materia")
    }
}