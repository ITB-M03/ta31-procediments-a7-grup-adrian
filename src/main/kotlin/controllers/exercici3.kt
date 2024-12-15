package org.example.controllers

import java.util.*

/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *
 * Escriu una funció anomenada "validarSuperusuari" que demani un password i
 * que el comprovi amb un text emmagatzemat en una constant interna. Si no
 * coincideix l’ha de tornar a demanar un màxim de 3 vegades. La funció ha de
 * tornar si l’usuari ha encertat o no el password.
 */

fun main() {
    processarValidacio()
}

/**
 * Funció que gestiona el procés de validació del superusuari.
 */
fun processarValidacio() {
    val contrasenya = "contrasenya" // Contrasenya emmagatzemada internament
    if (validarSuperusuari(contrasenya)) {
        println("Contrasenya vàlida")
    } else {
        println("No pots introduir més contrasenyes. Bloqueig del compte.")
    }
}

/**
 * Funció que valida si la contrasenya introduïda per l'usuari és correcta.
 * @param contrasenya La contrasenya que s'ha de validar.
 * @return true si la contrasenya és correcta, false en cas contrari.
 */
fun validarSuperusuari(contrasenya: String): Boolean {
    val scan = Scanner(System.`in`)
    var intents = 0 // Nombre d'intents realitzats per l'usuari
    do {
        intents++ // Incrementa el nombre d'intents
        print("Intent $intents de 3. Introdueix la contrasenya: ")
        val intentContrasenya = scan.nextLine() // Llegeix la contrasenya introduïda
        if (intentContrasenya == contrasenya) {
            return true // Retorna true si la contrasenya és correcta
        } else if (intents < 3) {
            println("Contrasenya incorrecta, torna a provar.")
        }
    } while (intents < 3) // Continua fins que es compleixin 3 intents

    return false // Retorna false si no s'ha encertat la contrasenya
}
