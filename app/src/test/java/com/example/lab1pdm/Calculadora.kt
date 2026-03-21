package com.example.lab1pdm

import org.junit.Test

class Calculadora(val marca: String, val durabilidad:Int, var precio: Double)
    {
        fun sumar(a:Double, b:Double)
            = a + b
        fun restar(a:Double, b:Double)
            = a- b
        fun multiplicar(a:Double, b:Double)
            = a * b

        fun dividir(a:Double, b:Double):String{
            return if (b != 0.0) {
                (a / b).toString()
            } else {
                "ups, no se puede dividir entre cero "
            }
        }
            fun bienvenida() {
                println()
                println("Hoy tenemos una nueva calcu es $marca")
                println("Precio: $$precio | Vida útil: ${durabilidad} años")
                println()

        }
    }

    class TestCalculadora {
        @Test

        fun probar(){
            val miCalcu = Calculadora("Casio", 3, 24.99)

            miCalcu.bienvenida()

            println("Sumar: ${miCalcu.sumar(24.00, 5.50)}")
            println("Restar: ${miCalcu.restar(10.0, 12.10)}")
            println("Multiplicar: ${miCalcu.multiplicar(9.0, 9.0)}")

            println("Division: ${miCalcu.dividir(88.0, 12.0)}")
            println("Division rara: ${miCalcu.dividir(99.0, 0.0)}")

            println()
            println("Gracias por usar mi calcu")
            println()
        }
    }
