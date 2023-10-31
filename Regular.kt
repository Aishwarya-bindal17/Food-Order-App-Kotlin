package foodOrderApp

class Regular : Customers(), OrderPayment {
    override fun payBill(amount: Double): Double {
        // 10% discount
        return amount * 0.9
    }
}