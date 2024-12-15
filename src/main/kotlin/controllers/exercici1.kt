package org.example.controllers

import java.text.SimpleDateFormat

/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 * Escriu una funció anomenada “calcularIVA” a la que se li passa un preu, un
 * tipus d’IVA i la data de la compra i retorna el preu amb l’IVA aplicat. El tipus
 * d’IVA pot ser General, Reduït, Superreduit o Exempt. El percentatge a aplicar
 * és el vigent en la data de compra i el podem trobar en aquesta taula:
 *
 * Data inici vigència General  Reduït  Superreduit     Exempt
 * 01-01-1986          12%      6%      No existeix     0%
 * 01-01-1992          15%      6%      No existeix     0%
 * 01-01-1993          15%      6%      3%              0%
 * 01-01-1995          16%      7%      4%              0%
 * 01-01-2010          18%      8%      4%              0%
 * 15-07-2012          21%      10%     4%              0%
 */

/**
 * Enumeració dels diferents tipus d'IVA amb els seus percentatges corresponents.
 */
enum class TipusIVA {
    General,
    Reduit,
    Superreduit,
    Exempt
}

fun main() {
    procesarIVA()
}

/**
 * Funció que recull les dades de l'usuari i crida a la funció calcularIVA.
 */
fun procesarIVA() {
    val preu = 100.0 // Exemple de preu del producte
    val tipusIVA = TipusIVA.General // Exemple de tipus d'IVA seleccionat
    val dataCompra = "20-06-1992" // Exemple de data de la compra

    val preuAmbIVA = calcularIVA(preu, tipusIVA, dataCompra)
    println("El preu amb l'IVA aplicat és: $preuAmbIVA")
}

/**
 * Funció que calcula l'IVA d'un preu en funció del tipus d'IVA i la data de compra.
 * @param preu Preu base del producte
 * @param tipusIVA Tipus d'IVA seleccionat (General, Reduït, Superreduit o Exempt)
 * @param dataCompra Data de la compra en format "dd-MM-yyyy"
 * @return Preu final amb l'IVA aplicat
 */
fun calcularIVA(preu: Double, tipusIVA: TipusIVA, dataCompra: String): Double {
    // Format de data per interpretar les dates
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")

    // Dates que delimiten els canvis en els tipus d'IVA
    val dataLimit1 = dateFormat.parse("01-01-1986")
    val dataLimit2 = dateFormat.parse("01-01-1992")
    val dataLimit3 = dateFormat.parse("01-01-1993")
    val dataLimit4 = dateFormat.parse("01-01-1995")
    val dataLimit5 = dateFormat.parse("01-01-2010")
    val dataLimit6 = dateFormat.parse("15-07-2012")

    // Conversió de la data de compra a objecte Date
    val dataCompraDate = dateFormat.parse(dataCompra)

    // Càlcul del percentatge d'IVA segons la data i el tipus seleccionat
    return when {
        dataCompraDate.before(dataLimit1) -> preu // No hi ha IVA abans del 1986

        dataCompraDate.before(dataLimit2) -> when (tipusIVA) {
            TipusIVA.General -> preu * 1.12
            TipusIVA.Reduit -> preu * 1.06
            TipusIVA.Superreduit -> preu
            TipusIVA.Exempt -> preu
        }

        dataCompraDate.before(dataLimit3) -> when (tipusIVA) {
            TipusIVA.General -> preu * 1.15
            TipusIVA.Reduit -> preu * 1.06
            TipusIVA.Superreduit -> preu * 1.03
            TipusIVA.Exempt -> preu
        }

        dataCompraDate.before(dataLimit4) -> when (tipusIVA) {
            TipusIVA.General -> preu * 1.16
            TipusIVA.Reduit -> preu * 1.07
            TipusIVA.Superreduit -> preu * 1.04
            TipusIVA.Exempt -> preu
        }

        dataCompraDate.before(dataLimit5) -> when (tipusIVA) {
            TipusIVA.General -> preu * 1.18
            TipusIVA.Reduit -> preu * 1.08
            TipusIVA.Superreduit -> preu * 1.04
            TipusIVA.Exempt -> preu
        }

        dataCompraDate.before(dataLimit6) -> when (tipusIVA) {
            TipusIVA.General -> preu * 1.21
            TipusIVA.Reduit -> preu * 1.10
            TipusIVA.Superreduit -> preu * 1.04
            TipusIVA.Exempt -> preu
        }

        else -> preu
    }
}
