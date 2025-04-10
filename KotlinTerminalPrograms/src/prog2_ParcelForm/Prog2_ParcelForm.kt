//simple form program
package prog2_ParcelForm

fun main() {
    println("Welcome to the Parcel Delivery Form!")
    val fName = getValidStringInput("Enter Firstname: ")
    val lName = getValidStringInput("Enter Lastname: ")
    val houseNo = getValidIntInput("Enter House No: ")
    val st = getValidStringInput("Enter Street: ")
    val vil = getValidStringInput("Enter Village: ")
    val city = getValidStringInput("Enter City: ")
    val prov = getValidStringInput("Enter Province: ")
    val cnt = getValidStringInput("Enter Country: ")

    displayParcelDetails(fName, lName, houseNo, st, vil, city, prov, cnt)
    println("Thank you! Your delivery details have been successfully recorded.")
}

fun getValidStringInput(prompt: String): String {
    var input: String
    do {
        print(prompt)
        input = readln().trim()
        if (input.isEmpty()) {
            println("Invalid input. Please try again.")
        }
    } while (input.isEmpty())
    return input
}

fun getValidIntInput(prompt: String): Int {
    do {
        print(prompt)
        val input = readln().toIntOrNull()
        if (input != null) {
            return input
        }else println("Invalid input. Please enter a valid number.")
    } while (true)
}

fun displayParcelDetails(fName: String, lName: String, houseNo: Int, st: String, vil: String, city: String, prov: String, cnt: String) {
    println("""
        Hello, $fName $lName!
        Your parcel will be delivered at: #$houseNo $st St. $vil Village, $city City, $prov, $cnt 
    """.trimIndent())
}
