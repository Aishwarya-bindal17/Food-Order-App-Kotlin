package foodOrderApp

interface OrderPayment {
    fun payBill(amount: Double): Double
}
