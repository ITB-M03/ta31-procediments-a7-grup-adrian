package org.example.controllers
import java.util.Scanner

/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *
 * Escriu una funció anomenada “roman” al que se li passa un número enter
 * entre 1 i 3999 i retorni un String amb el seu valor en números romans.
 *
 */

/**
 * Funció principal que crida a la funció [procesarNumero]
 */
fun main() {
    procesarNumero()
}

/**
 * Funció que llegeix un número de l'usuari i mostra el resultat en números romans.
 */
fun procesarNumero() {
    val scan = Scanner(System.`in`)
    var numero: Int
    do {
        print("Introdueïx un numero del 1 al 3999: ")
        numero = scan.nextInt()
    } while (numero !in 1..3999)
    println("$numero en números romans és ${roman(numero)}")
}

/**
 * Funció que converteix un número enter en un número romà
 * @param numero número enter a convertir
 * @return número romà
 */
fun roman(numero: Int): String {
    val traduccio = listOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var num = numero
    var resultatRoma = ""

    for ((valor, letra) in traduccio) {
        while (num >= valor) { // Mentre el número sigui major o igual al valor de la tupla
            resultatRoma += letra // Afegeix la lletra al resultat
            num -= valor // Resta el valor al número per seguir
        }
    }

    return resultatRoma
}
