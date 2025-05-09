package org.example

import kotlin.math.sqrt

fun main() {
    // Coeficientes de la función cuadrática f(x) = ax² + bx + c
    val a = 3
    val b = 4
    val c = 2

    // Verificación: a no debe ser cero
    if (a == 0) {
        println("Error: El coeficiente 'a' no debe ser igual a 0. No es una función cuadrática.")
        return
    }

    // Mostrar la función cuadrática
    println("==============================================")
    println("📌 Función cuadrática: f(x) = ${a}x² + ${b}x + ${c}")
    println("==============================================")

    // Mostrar tabla de valores para x desde -5 hasta 5
    println("\n📊 Tabla de valores de f(x):")
    println(String.format("%6s | %8s", "x", "f(x)"))
    println("---------------------------")
    for (x in -5..5) {
        val fx = calcularFuncionCuadratica(a, b, c, x)
        println(String.format("%6d | %8d", x, fx))
    }

    // Calcular y mostrar el discriminante
    val discriminante = calcularDiscriminante(a, b, c)
    println("\n🧮 Discriminante: $discriminante")

    // Analizar tipo de raíces según el discriminante
    when {
        discriminante < 0 -> {
            println("🔍 Resultado: La ecuación no tiene raíces reales (tiene dos raíces complejas).")
        }
        discriminante == 0 -> {
            println("🔍 Resultado: La ecuación tiene una única raíz real (raíz doble).")
            val (raiz1, _) = calcularRaices(a, b, discriminante)
            println("🔢 Raíz: x = %.2f".format(raiz1))
        }
        else -> {
            println("🔍 Resultado: La ecuación tiene dos raíces reales y distintas.")
            val (raiz1, raiz2) = calcularRaices(a, b, discriminante)
            println("🔢 Raíces:")
            println("x₁ = %.2f".format(raiz1))
            println("x₂ = %.2f".format(raiz2))
        }
    }
}

// Función que calcula f(x) = ax² + bx + c
fun calcularFuncionCuadratica(a: Int, b: Int, c: Int, x: Int): Int {
    return a * x * x + b * x + c
}

// Función que calcula el discriminante: D = b² - 4ac
fun calcularDiscriminante(a: Int, b: Int, c: Int): Int {
    return b * b - 4 * a * c
}

// Función que calcula las raíces reales (si existen), usando la fórmula general
fun calcularRaices(a: Int, b: Int, discriminante: Int): Pair<Double, Double> {
    val sqrtDiscriminante = sqrt(discriminante.toDouble())
    val x1 = (-b + sqrtDiscriminante) / (2 * a)
    val x2 = (-b - sqrtDiscriminante) / (2 * a)
    return Pair(x1, x2)
}
