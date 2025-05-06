package org.example
import kotlin.math.sqrt

fun main() {
    val a = 3
    val b = 4
    val c = 2

    if (a == 0) {
        println("a no debe ser igual a 0")
        return
    }

    println("La función es: ${a}x² + ${b}x + ${c}")
    println("\nTabla de valores de f(x):")
    println(String.format("%6s | %6s", "x", "f(x)"))
    println("---------------")
    for (x in -5..5) {
        val fx = calcularFuncionCuadratica(a, b, c, x)
        println(String.format("%6d | %6d", x, fx))
    }

    // Cálculo del discriminante y las raíces
    val discriminante = calcularDiscriminante(a, b, c)
    println("\nDiscriminante: $discriminante")

    if (discriminante < 0) {
        println("La ecuación no tiene raíces reales.")
    } else {
        val (raiz1, raiz2) = calcularRaices(a, b, discriminante)
        println("Raíces:")
        println("x₁ = %.2f".format(raiz1))
        println("x₂ = %.2f".format(raiz2))
    }
}

// f(x) = ax² + bx + c
fun calcularFuncionCuadratica(a: Int, b: Int, c: Int, x: Int): Int {
    return a * x * x + b * x + c
}

// Discriminante: b² - 4ac
fun calcularDiscriminante(a: Int, b: Int, c: Int): Int {
    return b * b - 4 * a * c
}

// Raíces reales (con decimales)
fun calcularRaices(a: Int, b: Int, discriminante: Int): Pair<Double, Double> {
    val sqrtDiscriminante = sqrt(discriminante.toDouble())
    val x1 = (-b + sqrtDiscriminante) / (2 * a)
    val x2 = (-b - sqrtDiscriminante) / (2 * a)
    return Pair(x1, x2)
}
