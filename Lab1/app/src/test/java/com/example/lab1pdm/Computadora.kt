package com.example.lab1pdm

import org.junit.Test

class Computadora(val marca:String, var sistema:String, var ram:Int, var espacio: Int){
        var programasInstalados = listOf<String>()

        fun encender() {
            println()
            println("Hola, bienvenido a tu compu $marca")
            println("La compu se está encendiendo, dame unos segundos porfita...")
            println()
        }
        fun apagar(){
            println("Cerrando sesión $sistema")
            println("Nos vemos pronto, gracias por usar $marca ;)")
            println()
        }

        fun cambiarRam(ramCambiada:Int){
            ram = ramCambiada
            println("El RAM ha sido actualizado, ahora tienés $ram GB")
        }
        fun cambiarEspacio(espacioCambiado:Int){
            espacio = espacioCambiado
            println("Almacenamiento actualizado, ahora tienés $espacio GB")
        }
        fun cambiarSistema(sistemaCambiado: String){
            sistema=sistemaCambiado
            println("Sistema cambiado a $sistema")
        }

        fun programas() = programasInstalados.filter {
            it.contains("2026")
        }
    }

    class TestComputadora{
        @Test
        fun probar(){
            val miCompu= Computadora("HP", "Windows 11", 16, 512)

            miCompu.encender()

            miCompu.programasInstalados = listOf(
                "Spotify 2023",
                "Telegram 2022",
                "Whatsapp 2026",
                "Instagram 2025",
                "BeReal 2026",
                "Facebook 2021"
            )

            val filtrar = miCompu.programas()
            println("Programas del año:")
            println(filtrar)
            println()

            miCompu.cambiarRam(32)
            miCompu.cambiarEspacio (espacioCambiado = 1024)
            println()

            miCompu.apagar()
        }
    }
