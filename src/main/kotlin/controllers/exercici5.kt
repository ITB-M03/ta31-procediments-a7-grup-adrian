package org.example.controllers

import java.util.*

/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *
 * Implementa un programa que faci servir un tipus de dada anomenat “Pila”.
 * Una pila és un tipus de dada on es van afegint valors i es van traient en l’ordre
 * invers al qual s’han afegit, també conegut com LIFO (Last In First Out). El
 * programa ha de presentar el següent menú d’opcions:
 * 1.- Afegir número (push)
 * 2.- Treure número (pop)
 * 3.- Mostrar contingut de la pila
 * 4.- Sortir
 * La pila ha d’admetre com a màxim 10 valors. Si intentem afegir un onzè
 * element el sistema no ho ha de permetre i ha d’avisar a l’usuari que la pila es
 * troba plena. De la mateixa manera, si intentem treure un número d’una pila que
 * es troba buida, també s’ha d’informar a l’usuari que no pot fer aquesta
 * operació.
 * En treure un número de la pila, s’ha de mostrar per pantalla quin és el número
 * que s’ha tret.
 * El programa s’ha d’implementar amb un array. No es poden fer servir els tipus
 * de dades de les llibreries de Kotlin.
 *
 */

/**
 * Funció principal que crida a la funció gestionarMenu.
 */
fun main() {
    Menu() // Crida a la funció principal del programa
}

/**
 * Funció que gestiona el menú i les operacions sobre la pila.
 */
fun Menu() {
    val pila = Pila()
    val scanner = Scanner(System.`in`)

    while (true) { // Bucle per mostrar el menú contínuament
        println("\nMenú d'opcions:")
        println("1. Afegir número (push)")
        println("2. Treure número (pop)")
        println("3. Mostrar contingut de la pila")
        println("4. Sortir")
        print("Escull la opció que vulguis: ")

        when (val opcio = scanner.nextInt()) {
            1 -> {
                print("Introdueix el número a afegir: ")
                val num = scanner.nextInt()
                pila.push(num)
            }

            2 -> pila.pop()
            3 -> pila.ensenyarContingut()
            4 -> {
                println("No ploris, ens veurem aviat!")
                return
            }

            else -> println("No es pot fer això perquè no és vàlid.")
        }
    }
}

/**
 * Classe que representa una pila bàsica utilitzant un array d'enters.
 * La pila té una capacitat màxima de 10 elements.
 */
class Pila {
    private val elements = IntArray(10)
    private var top = -1

    /**
     * Mètode per afegir un element a la pila.
     * @param element L'element a afegir.
     */
    fun push(element: Int) {
        if (top < 9) { // Comprovar si la pila està plena
            top++ // Incrementar el top
            elements[top] = element // Afegir element a la pila
            println("Número $element afegit a la pila.") // Mostrar l'element afegit
        } else {
            println("La pila està plena. No es pot afegir més elements.") // Mostrar missatge si la pila està plena
        }
    }

    /**
     * Mètode per treure un element de la pila.
     */
    fun pop() {
        if (top >= 0) { // Comprovar si la pila està buida
            val element = elements[top] // Guardar l'element a treure
            top-- // Decrementar el top
            println("El número $element s'ha tret de la pila.") // Mostrar l'element tret
        } else {
            println("Hey! Que això està buit.") // Mostrar missatge si la pila està buida
        }
    }

    /**
     * Mètode per mostrar el contingut de la pila.
     */
    fun ensenyarContingut() {
        if (top >= 0) { // Comprovar si la pila està buida
            println("Contingut de la pila:") // Mostrar missatge
            for (i in top downTo 0) { // Recórrer la pila des del top fins al principi
                println(elements[i]) // Mostrar l'element
            }
        } else {
            println("La pila està buida.") // Mostrar missatge si la pila està buida
        }
    }
}
