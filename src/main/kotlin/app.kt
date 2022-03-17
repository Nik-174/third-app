import java.util.concurrent.ThreadLocalRandom

fun main() {
    for (i in 0..30) {
        agoToText(randomInt(0, (60 * 60 * 24 * 3)))
    }
}

fun agoToText(time: Int) {
    when (time) {
        in 0..60 -> println("был(а) только что")
        in 61..3600 -> minutsClocks(time)
        in (60 * 60 + 1)..(24 * 60 * 60) -> minutsClocks(time)
        in (24 * 60 * 60 + 1)..(24 * 60 * 60 * 2) -> println(" был(а) в сети сегодня")
        in (24 * 60 * 60 + 1 * 2)..(24 * 60 * 60 * 3) -> println(" был(а) в сети вчера")
        else -> println("был(а) в сети давно")
    }
}

fun randomInt(FirstNum: Int, LastNum: Int): Int {
    val random = ThreadLocalRandom.current().nextInt(FirstNum, LastNum)
    return random
}

fun minutsClocks(namber: Int) {
    if (namber < 3600) {
        val minut = namber / 60
        if (minut in 11..15) println(" был(а) в сети $minut минут назад")
        else if (minut % 10 == 1) println("был(а) в сети $minut минуту назад ")
        else if (minut % 10 in 2..4) println(" был(а) в сети $minut минуты назад")
        else println(" был(а) в сети $minut минут назад")
    } else {
        val clock = namber / 3600
        if (clock in 11..15) println(" был(а) в сети $clock часов назад")
        else if (clock % 10 == 1) println("был(а) в сети $clock час назад ")
        else if (clock % 10 in 2..4) println(" был(а) в сети $clock часа назад")
        else println(" был(а) в сети $clock часов назад")
    }
}