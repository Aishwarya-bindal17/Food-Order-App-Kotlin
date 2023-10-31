package foodOrderApp

class Premium : Customers(), OrderPayment {
    override fun payBill(amount: Double): Double {
        // 20% discount
        return amount * 0.8
    }
}