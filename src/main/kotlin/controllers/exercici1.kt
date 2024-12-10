package org.example.controllers
import java.text.SimpleDateFormat


/**
 * @author Adrián Galinsoga
 * @date 10/12/2024
 *Escriu una funció anomenada “calcularIVA” a la que se li passa un preu, un
 *tipus d’IVA i la data de la compra i retorna el preu amb l’IVA aplicat. El tipus
 *d’IVA pot ser General, Reduït, Superreduït o Exempt. El percentatge a aplicar
 *és el vigent en la data de compra i el podem trobar en aquesta taula:
 *
 * Data inici vigència General  Reduït  Superreduit     Exempt
 * 01-01-1986          12%      6%      No existeix     0%
 * 01-01-1992          15%      6%      No existeix     0%
 * 01-01-1993          15%      6%      3%              0%
 * 01-01-1995          16%      7%      4%              0%
 * 01-01-2010          18%      8%      4%              0%
 * 15-07-2012          21%      10%     4%              0% *
 *
 */


/**
 * Enumeració dels diferents tipus d'IVA amb els seus percentatges corresponents.
 */


enum class TipusIVA {
    General,
    Reduit,
    Superreduit,
}

fun main() {
    val preu = 100.0
    val tipusIVA = TipusIVA.General
    val dataCompra = "20-06-1992"

    val preuAmbIVA = calcularIVA(preu, tipusIVA, dataCompra)
    println("El preu amb l'IVA aplicat és: $preuAmbIVA")
}




fun calcularIVA(preu: Double, tipusIVA: TipusIVA, dataCompra: String): Double {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    val dataLimit1 = dateFormat.parse("01-01-1986")
    val dataLimit2 = dateFormat.parse("01-01-1992")
    val dataLimit3 = dateFormat.parse("01-01-1993")
    val dataLimit4 = dateFormat.parse("01-01-1995")
    val dataLimit5 = dateFormat.parse("01-01-2010")
    val dataLimit6 = dateFormat.parse("15-07-2012")

    val dataCompraDate = dateFormat.parse(dataCompra)

    return when {
        dataCompraDate.before(dataLimit1) -> preu * 12 / 100
        dataCompraDate.before(dataLimit2) -> {
            when (tipusIVA) {
                TipusIVA.General -> preu * 12 / 100
                TipusIVA.Reduit -> preu * 6 / 100
                else -> preu
            }
        }
        dataCompraDate.before(dataLimit3) -> {
            when (tipusIVA) {
                TipusIVA.General -> preu * 15 / 100
                TipusIVA.Reduit -> preu * 6 / 100
                TipusIVA.Superreduit -> preu * 3 / 100
            }
        }
        dataCompraDate.before(dataLimit4) -> {
            when (tipusIVA) {
                TipusIVA.General -> preu * 16 / 100
                TipusIVA.Reduit -> preu * 7 / 100
                TipusIVA.Superreduit -> preu * 4 / 100
            }
        }
        dataCompraDate.before(dataLimit5) -> {
            when (tipusIVA) {
                TipusIVA.General -> preu * 18 / 100
                TipusIVA.Reduit -> preu * 8 / 100
                TipusIVA.Superreduit -> preu * 4 / 100
            }
        }
        dataCompraDate.before(dataLimit6) -> {
            when (tipusIVA) {
                TipusIVA.General -> preu * 21 / 100
                TipusIVA.Reduit -> preu * 10 / 100
                TipusIVA.Superreduit -> preu * 4 / 100
            }
        }
        else -> preu
    }
}

