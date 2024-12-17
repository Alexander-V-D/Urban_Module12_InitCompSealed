import kotlinx.coroutines.delay

suspend fun main() {
    selectMenu(selectedMenu())
}

fun selectedMenu(): Coffee {

    var name: String
    while (true) {
        println("Выберите кофе:")
        name = readln()
        when(name) {
            in listOf("Americano", "Cappuccino", "Latte") -> break
            else -> continue
        }
    }

    var sugar: String
    while (true) {
        println("Количество сахара:")
        sugar = readln()
        try {
            sugar.toInt()
            break
        }
        catch (e: Exception) {
            continue
        }
    }

    var volume: String
    while (true) {
        println("Объем кофе:")
        volume = readln()
        try {
            volume.toDouble()
            break
        }
        catch (e: Exception) {
            continue
        }
    }

    var milk = ""
    if (name == "Latte") while (true) {
        println("Объем молока:")
        milk = readln()
        try {
            milk.toDouble()
            break
        }
        catch (e: Exception) {
            continue
        }
    }
    return when(name) {
        "Americano" -> Coffee.Americano(sugar, volume)
        "Cappuccino" -> Coffee.Cappuccino(sugar, volume)
        else -> Coffee.Latte(sugar, volume, milk)
    }
}

suspend fun selectMenu(menu: Coffee) {
    for (process in 10..100 step 10) {
        delay(500L)
        print("$process% ")
        if (process == 100) println()
    }
    println("Ваш кофе готов: ${menu.name}, сахар: ${menu.sugar}, объем: ${menu.volume}" +
            if (menu is Coffee.Latte) " молоко: ${menu.milk}" else ""
    )
}