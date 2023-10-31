package foodOrderApp
import java.util.*
class Restaurant constructor(address: String, contactNumber: String, email: String) {
    //var name: String
    var address: String
    var contactNumber: String
    var email: String

    init {
      //  this.name = name
        this.address = address
        this.contactNumber = contactNumber
        this.email = email
    }

    companion object {
        var restName="ABC Restaurant"
    }


    fun displayDetails() {
        println("------ ${Restaurant.restName} Details---------")
        println()
        println("Name: ${Restaurant.restName}")
        println("Address: " + address)
        println("Contact Number: $contactNumber")
        println("Email id: $email")
        println()
    }
}
fun Restaurant.choose() {
    println("Welcome to ${Restaurant.restName}!")
    println()
    println("Please choose an option:")
    println("1. Dine-In")
    println("2. Online Order")

    var sc = Scanner(System.`in`)
    var choice = sc.nextInt()

    when (choice) {
        1 -> println("You have chosen to dine in at ${Restaurant.restName}.")
        2 -> println("You have chosen to place an online order from ${Restaurant.restName}.")
        else -> println("Invalid choice. Please select 1 for dine-in or 2 for online order.")
    }
}