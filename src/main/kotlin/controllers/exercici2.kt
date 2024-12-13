package org.example.controllers
import java.util.Scanner

/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *
 *
 * Escriu una funció anomenada “roman” al que se li passa un número enter
 * entre 1 i 3999 i retorni un String amb el seu valor en números romans.
 *
 */

fun roman(numero: Int): String {
    /*Llistat de tuples amb la conversió de decimal a romà
    Els valors 4,5,40,90,400 i 900, serveixen per a delimitar els valors ex: 4 = IV 4!= IIII
    */
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
        while (num >= valor) { //Mentre el número sigui major o igual al valor de la tupla
            resultatRoma += letra //Afegeix la lletra al resultat
            num -= valor //Resta el valor al número per seguir
        }
    }

    return resultatRoma
}

fun main() {
    var numero: Int
    val scan = Scanner(System.`in`)
    do {
        print("Introdueïx un numero del 1 al 3999: ")
        numero = scan.nextInt()
    } while (numero !in 1..3999)
    println("$numero en números romans és ${roman(numero)}")
}