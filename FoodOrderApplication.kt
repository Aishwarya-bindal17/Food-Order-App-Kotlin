package foodOrderApp

fun main() {
    var c = Customers()
    c.getData()
    c.display()

    val restaurant1 = Restaurant("123 Main Street",
        "1234567890", "myrestaurant@gmail.com")
    restaurant1.displayDetails()
    restaurant1.choose()

    Menu.display()

    var o=order()
    o.getData()
    o.display(c.cid)



}