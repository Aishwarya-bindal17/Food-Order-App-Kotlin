package foodOrderApp

class Address(var street: String, var city: String, var zip: String) {

    val addressDetails: String
        get() = "$street, $city, $zip"
}
