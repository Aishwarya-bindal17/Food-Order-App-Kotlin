package foodOrderApp
import java.lang.IllegalArgumentException
import java.util.*

    open class Customers {

        var name: Name? = null
        var cid: String = ""
        var address: Address? = null
        var phoneNo: Long = 0

     fun getData() {
        println("Please enter your details: ")
        var sc = Scanner(System.`in`)
        println("Name: ")
        name = Name(sc.next(),sc.next(),sc.next());
        println("id: ")
         cid = sc.next()
         if (cid.startsWith("p") || cid.startsWith("r") || cid.startsWith("g")) {
            // println("eligible")
         }
         else
         {
             throw IllegalArgumentException("customer id can only start with r,g or p")
         }
        println("address(street,city,zip): ")
         address = Address(sc.next(), sc.next(), sc.next())
        println("phoneNo: ")
        phoneNo = sc.nextLong()
    }
    fun display() {
        println("User details are: ")
        println("Name: "+ (name?.fullName ?: ""))
        println("id: $cid")
        System.out.println("address: "+ (address?.addressDetails ?: ""));
        println("phone Number: $phoneNo")
        // println("Customer type: "+ cusType);
        println()
        println()
    }
}