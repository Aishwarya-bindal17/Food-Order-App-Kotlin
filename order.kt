package foodOrderApp
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import java.io.File

class order {
    var qty: Int = 0
    var res: Int = 0
    var tprice: Double = 0.0
    var sqty = 0
    var pizzaqty = 0
    var pastaqty = 0
    var bqty = 0

    // Lambda function to calculate the total price for an item according to the quantity
    val pricePerItem: (Int, Int) -> Double = { itemPrice, quantity ->
        itemPrice * quantity.toDouble()
    }

    fun getData() {
        val sc = Scanner(System.`in`)
        var run = true

        while (run) {
            println("Please Select item number or select 5 to exit: ")
            res = sc.nextInt()
            if (res in 1..5) {

            } else {
                throw IllegalArgumentException("Item not present in menu")
            }

            when (res) {
                1 -> {
                    println("Sandwich selected")
                    println("Select quantity:")
                    qty = sc.nextInt()
                    val totalItemPrice = pricePerItem(100, qty)
                    tprice += totalItemPrice
                    sqty = qty
                }

                2 -> {
                    println("Pizza selected")
                    println("Select quantity:")
                    qty = sc.nextInt()
                    val totalItemPrice = pricePerItem(300, qty)
                    tprice += totalItemPrice
                    pizzaqty = qty
                }

                3 -> {
                    println("Burger selected")
                    println("Select quantity:")
                    qty = sc.nextInt()
                    val totalItemPrice = pricePerItem(100, qty)
                    tprice += totalItemPrice
                    bqty = qty
                }

                4 -> {
                    println("Pasta selected")
                    println("Select quantity:")
                    qty = sc.nextInt()
                    val totalItemPrice = pricePerItem(250, qty)
                    tprice += totalItemPrice
                    pastaqty = qty
                }

                5 -> run = false
                else -> println("Wrong Input")
            }
        }
    }

    fun display(cusId: String) {
        var finalPrice: Double
        var customerType = "Guest"

        if (cusId.startsWith("p")) {
            finalPrice = Premium().payBill(tprice)
            customerType = "Premium"
        }
        else if (cusId.startsWith("r")) {
            finalPrice = Regular().payBill(tprice)
            customerType = "Regular"
        }
        else {
            finalPrice = Guest().payBill(tprice)
        }

        val outputFileName = when {
            cusId.startsWith("p") -> "premium.txt"
            cusId.startsWith("r") -> "regular.txt"
            else -> "guest.txt"
        }

        val outputFile = File(outputFileName)
        outputFile.appendText("-----------   ABC Restaurant    ----------\n")
        outputFile.appendText("Order details are:\n")
        outputFile.appendText("Customer Type: $customerType\n")
        outputFile.appendText("Ordered Items:\n")
        outputFile.appendText("   Item    Quantity\n")
        if (sqty > 0) {
            outputFile.appendText("  Sandwich   $sqty\n")
        }
        if (pizzaqty > 0) {
            outputFile.appendText("  Pizza      $pizzaqty\n")
        }
        if (pastaqty > 0) {
            outputFile.appendText("  Pasta      $pastaqty\n")
        }
        if (bqty > 0) {
            outputFile.appendText("  Burger     $bqty\n")
        }
        outputFile.appendText("Total Amount: Rs $tprice\n")
        if (cusId.startsWith("g")) {
            outputFile.appendText("Payable Amount after adding delivery charge: Rs $finalPrice\n")
        } else {
            outputFile.appendText("No delivery charge\n")
            outputFile.appendText("Payable Amount after discounts: Rs $finalPrice\n")
        }
        val ld = LocalDate.now()
        outputFile.appendText("date: $ld\n")
        val lt = LocalTime.now()
        outputFile.appendText("time: $lt\n")
        outputFile.appendText("\n")

        println("Order details written to $outputFileName.")

        var data= outputFile.readText()
        println(data)
    }
}

