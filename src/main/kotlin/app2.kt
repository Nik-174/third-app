fun main() {
    while (true) {
        enter()
    }
}


fun enter() {
    val card: String
    val sumManth: Int
    val sumDay: Int

    println(" Введите тип карты:")
    println("1. Vk Pay")
    println("2. Maestro")
    println("3. MasterCard")
    println("4. Visa")
    println("5. Мир")
    try {
        card = readLine().toString()
        if (card.equals("Maestro") || card.equals("MasterCard ") ||
            card.equals("Visa") || card.equals("Мир") || card.equals(
                "Vk Pay"
            )
        ) {
            println("Введено верно")
        } else {
            println("Введено не верно")
            throw  Exception()
        }
        println("введите сумму переводов в текущем месяце:")
        sumManth = readLine().toString().toInt()
        println("введите сумму совершаемого перевода:")
        sumDay = readLine().toString().toInt()
    } catch (e: Exception) {
        return println("Нужно верно вводить параметры !")
    }
    if (limit(card = card, sumInManth = sumManth, transferCash = sumDay)) {
        println(" Комиссия составляеьт ${cash(card, sumManth, sumDay)} копеек")
    }
}

fun cash(card: String, sumInManth: Int, transferCash: Int): Int {
    var sum = 0

    if (card.equals("Maestro") || card.equals("MasterCard ")) {
        if (sumInManth < 75000) {
            sum = 0
        } else {
            sum = ((transferCash / 100 * 0.6 + 20) * 100).toInt()
        }
    } else if (card.equals("Visa") || card.equals("Мир")) {
        if (transferCash >= (transferCash / 100 * 0.75)) {
            sum = ((transferCash / 100 * 0.75) * 100).toInt()
        } else if (card.equals("Vk Pay")) {
            sum = 0
        } else {
            println("Что то не то")
        }
    }
    return sum
}

fun limit(card: String, sumInManth: Int, transferCash: Int): Boolean {
    var lim = true
    if (card.equals("Vk Pay")) {
        if (transferCash > 15000) {
            println(
                "Ваша сумма больше 15000 рублей! " +
                        "Можно перевести не более 15000 рублей за один перевод"
            )
            lim = false
        }
        if (sumInManth > 40000) {
            println(
                "Ваша сумма перевода больше 40000 рублей в месяц! " +
                        "Можно перевести не более 40000 рублей в месяц"
            )
            lim = false
        }
    } else if (card.equals("Visa") || card.equals("Мир")) {
        if (transferCash <= 35) {
            println("Минимальная сумма перевода 35 рублей")
            lim = false
        }
    } else {
        if (transferCash > 150000) {
            println("Вы привысили суточный лимит")
            lim = false
        }
        if (sumInManth > 600000) {
            println("Вы привысили месячный лимит")
            lim = false
        }

    }
    return lim
}