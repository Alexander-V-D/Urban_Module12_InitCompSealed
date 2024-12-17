sealed class Coffee(val name: String, val sugar: String, val volume: String) {
    class Americano(sugar: String, volume: String): Coffee("Americano", sugar, volume)
    class Cappuccino(sugar: String, volume: String): Coffee("Cappuccino", sugar, volume)
    class Latte(sugar: String, volume: String, val milk: String): Coffee("Latte", sugar, volume)
}