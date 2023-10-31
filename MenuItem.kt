package foodOrderApp
data class MenuItem(val id: Int, val name: String, val price: Int)

object Menu {
    val menuItems = mutableListOf<MenuItem>()

    init {
        menuItems.add(MenuItem(1, "Sandwich", 100))
        menuItems.add(MenuItem(2, "Pizza", 300))
        menuItems.add(MenuItem(3, "Burger", 100))
        menuItems.add(MenuItem(4, "Pasta", 250))
    }

    fun display() {
        println("----------   Menu    ------------")
        println()
        for (item in menuItems) {
            println("${item.id}. ${item.name}   Rs${item.price}")
        }
    }
}
