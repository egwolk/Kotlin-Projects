//program that allows user to input 2 numbers and program will display sum, difference, product, quotient, and remainder of the 2 numbers.
import java.text.DecimalFormat
const val UNDEFINED = "UNDEFINED"
fun main() {
    while (true) {
        val n1 = isDouble("Enter 1st number: ")
        val n2 = isDouble("Enter 2nd number: ")
        val clN1 = numFormat(n1)
        val clN2 = numFormat(n2)

        val quo = getQuo(n1, n2)
        val mod = getMod(n1, n2)

        println()
        println("$clN1 + $clN2 = ${numFormat(getSum(n1, n2))}")
        println("$clN1 - $clN2 =  ${numFormat(getDif(n1, n2))}")
        println("$clN1 * $clN2 =  ${numFormat(getPro(n1, n2))}")
        println("$clN1 / $clN2 =  ${quo?.let {numFormat(it)} ?: UNDEFINED}")
        println("$clN1 % $clN2 =  ${mod?.let {numFormat(it)} ?: UNDEFINED}")
        println()
        val res :Char = restart("Start again? [Y] Yes | [N] No:")
        if (!res.equals('y',true)) {
            println("Goodbye!")
            break
        }else println()
    }
}
fun restart(prompt: String):Char { // for program restart
    var c: Char? = null
    do {
        print(prompt)
        val uIn = readln().lowercase()
        if (uIn.length != 1 || !(uIn.equals("y",true) ||uIn.equals("n",true)) ) println("Invalid input.") else c = uIn[0]
    }while(c==null)
    return c
}
fun numFormat(value: Double): String { //number format
    val formatter = DecimalFormat("0.##")
    return if (value % 1.0 == .0) value.toInt().toString() else formatter.format(value)
}

fun isDouble(prompt: String):Double { //number input validation
    var n : Double?
    do{
        print(prompt)
        n = readln().toDoubleOrNull()
        if (n == null) {
            println("Invalid input. Please enter a valid integer.")
        }
    }while(n == null)
    return n
}

//Arithmetic operations
fun getSum(a: Double, b:Double) = a + b
fun getDif(a: Double, b:Double) = a - b
fun getPro(a: Double, b:Double) = a * b
fun getQuo(a: Double, b:Double) :Double? {
    return if (b == .0) null else a / b
}
fun getMod(a: Double, b:Double) :Double? {
    return if (b == .0) null else a % b
}