package org.example

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
}

// Función para calcular f(x) = ax² + bx + c
fun calcularFuncionCuadratica(a: Int, b: Int, c: Int, x: Int): Int {
    return a * x * x + b * x + c
}
