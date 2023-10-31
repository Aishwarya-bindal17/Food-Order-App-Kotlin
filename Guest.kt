package foodOrderApp

class Guest : Customers(), OrderPayment {
    override fun payBill(amount: Double): Double {
        // Guest doesn't get any discount but pays 5% delivery charge
        val deliveryCharge = amount * 0.05
        return amount + deliveryCharge
    }
}