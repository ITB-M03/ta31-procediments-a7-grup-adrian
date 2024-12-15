package org.example.controllers

import java.util.*


/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *
 * Escriu un procediment anomenat “titol” que donat un text, el mostri per
 * pantalla de forma centrada. Pots assumir que la pantalla té un ample de 80
 * caràcters.
 *
 */

/**
 * Procediment que mostra un text centrat en la pantalla
 * @param text text a mostrar
 * @param ample ample de la pantalla
 * @return text centrat
 */
fun titol(text: String) { //creem la funció titol amb el parametre text
    val ample = 80 //amplada de la pantalla
    val tabs = (ample - text.length) / 2 //calculem els espais que hi ha entre el text i el marge de la pantalla
    for (i in 1..tabs) { //bucle per imprimir els espais
        print(" ") //imprimim els espais

    }
    println(text) //imprimim el text
}

/**
 * Funció principal que crida a la funció titol
 */
fun main() {
    val scan = Scanner(System.`in`)
    print("Introdueix un text: ") //imprimim el missatge
    val text = scan.nextLine() //escaneig del text
    titol(text) //cridem a la funció titol amb el parametre text
}