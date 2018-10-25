val table = hashMapOf(
        0 to "cero",
        1 to "uno",
        2 to "dos",
        3 to "tres",
        4 to "cuatro",
        5 to "cinco",
        6 to "seis",
        7 to "siete",
        8 to "ocho",
        9 to "nueve",
        10 to "diez",
        11 to "once",
        12 to "doce",
        13 to "trece",
        14 to "catorce",
        15 to "quince",
        20 to "veinte",
        30 to "treinta",
        40 to "cuarenta",
        50 to "cincuenta",
        60 to "sesenta",
        70 to "setenta",
        80 to "ochenta",
        90 to "noventa",
        100 to "cien",
        200 to "doscientos",
        300 to "trescientos",
        400 to "cuatrocientos",
        500 to "quinientos",
        600 to "seiscientos",
        700 to "setecientos",
        800 to "ochocientos",
        900 to "novecientos",
        1000 to "mil",
        1000000000 to "millon",
        1000000000000 to "mil millione"
)

fun helper(number : Int) : String? {
    return when (number) {
        in table.keys -> table[number]
        in 16..19 -> "dieci${table[number % 10]}"
        in 21..29 -> "veinti${table[number % 10]}"
        in 31..99 -> "${table[number - number % 10]} ${table[number % 10]}"
        in 101..999 -> "${table[number - number % 100]} ${helper(number % 100)}"
        else -> throw IllegalArgumentException()
    }
}

fun toWords(number : Int) : String? {
    if (number < 0 || number > 1000000000) {
        throw IllegalArgumentException()
    }

    return when (number) {
        in table.keys -> table[number]
        in 16..29 -> helper(number)
        in 31..99 -> "${table[number - number % 10]} y ${table[number % 10]}"
        in 101..999 -> "${table[number - number % 100]} ${toWords(number % 100)}"

        in 1001..999999 -> {
            val thousand = number / 1000
            "${if (thousand > 1) helper(thousand) else ""} mil " +
                    "${if (number % 1000 != 0) toWords(number % 1000) else ""}"
        }

        in 1000001..99999999 -> {
            val millions = number / 1000000
            "${helper(millions)} millon${if (millions > 1) "es" else ""} " +
                    "${if (number % 1000000 != 0) toWords(number % 1000000) else ""}"
        }

        else -> throw IllegalArgumentException()
    }?.trim()
}