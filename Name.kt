package foodOrderApp

class Name(var fName: String, var mName: String, var lName: String) {

    val fullName: String
        get() = "$fName $mName $lName"
}
