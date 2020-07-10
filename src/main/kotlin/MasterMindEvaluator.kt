fun main() {
    print("Enter the key string:")
    val key = readLine()!!
    print("Enter the guess string:")
    val guess = readLine()!!

    val result = key.evaluate(guess)
    print("Please find the result for each index \n $result")
}

fun String.evaluate(guessString: String): HashMap<Int, String> {
    val result: HashMap<Int, String> = hashMapOf()
    var found: Boolean

    if(this.length != guessString.length)
        throw Exception("Incorrect input provided for guess string. Please provide an input which is same length string as the key string")

    for (i in guessString.indices) {
        if (this[i] == guessString[i]) {
            result[i] = "Right character and right position"
        } else {
            found = false
            for (j in this.indices) {
                if (this[j] == guessString[i]) {
                    found = true
                    result[i] = "Right character but incorrect position"
                    break
                }
            }
            if (!found) result[i] = "Incorrect character and incorrect position"
        }
    }
    return result
}