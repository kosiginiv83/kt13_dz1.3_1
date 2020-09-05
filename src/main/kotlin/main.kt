fun main() {
    val seconds: Array<Long> = arrayOf(0, 1, 59, 60, 61, 121, 1650, 3600, 3601,
            7201, 19_000, 75_600, 30298342093842093)
    seconds.map { println("был(а) в сети ${getTimeStr(it)}") }
}


fun getTimeStr(seconds: Long): String = when (seconds) {
    in 0..60 -> "только что"
    in 61..3600 -> getMinutesFormat(seconds / 60) + " назад"
    in 3601..86_400 -> getHoursFormat(seconds / 3600) + " назад"
    in 86_401..172_800 -> "вчера"
    in 172_801..259_200 -> "позавчера"
    else -> "давно"
}


fun getMinutesFormat(minutes: Long): String = when (minutes) {
    in  2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$minutes минуты"
    in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "$minutes минут"
    else -> "$minutes минуту"
}


fun getHoursFormat(hours: Long): String = when {
    hours in 2..4 || hours in 22..23 -> "$hours часа"
    hours in 5..20 -> "$hours часов"
    else -> "$hours час"
}