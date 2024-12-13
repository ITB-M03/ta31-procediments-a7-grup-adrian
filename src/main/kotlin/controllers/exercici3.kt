package org.example.controllers

import java.util.*


/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *
 * Escriu una funció anomenada “validarSuperusuari” que demani un password i
 * que el comprovi amb un text emmagatzemat en una constant interna. Si no
 * coincideix l’ha de tornar a demanar un màxim de 3 vegades. La funció ha de
 * tornar si l’usuari ha encertat o no el password.
 *
 */

fun validarSuperusuari(scan: Scanner, contrasenya: String): Boolean {
    var intents = 0 //creem la variable a 0 que serán els intents de l'usuari
    do {
        intents++ //cada cop que pasem pel bucle incrementem els intents
        print("Intent $intents de 3 Introdueix la contrasenya: ") //imprimim un missatge on posen els intent
        val intentContrasenya = scan.nextLine() // escaneig dels intents de la contrasenya
        if (intentContrasenya == contrasenya) { //si el intent es igual a la contrasenya camnviem el boolea a true
            return true
        } else if (intents < 3) { //en cas de que el intents siguin majors a 3 printem el misatge de contrasenya incorrecta
            println("Contrasenya incorrecta, torna a provar") //imprimim el mistage
        }
    } while (intents < 3) //sortim del do while si els intents son mes grans que 3
    return false
}

fun main() {
    val scan = Scanner(System.`in`)
    val contrasenya = "contrasenya"
    if (validarSuperusuari(scan, contrasenya)) {
        println("Contrasenya Válida")
    } else {
        println("No pots possar mes la contrasenya, bloqueig de la conta")
    }
}