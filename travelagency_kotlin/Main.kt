fun main() {

    println("============================================================")
    println("       TRAVEL AGENCY SIMULATOR - Kotlin Implementation      ")
    println("============================================================")

    var running = true

    while (running) {

        println()
        print("Enter customer name: ")
        val name = readLine()?.trim() ?: "Jane"

        print("Enter customer age: ")
        val age = readLine()?.trim()?.toIntOrNull() ?: 0

        print("Does customer have a passport? (true/false): ")
        val hasPassport = readLine()?.trim().equals("true", ignoreCase = true)

        print("Enter quotation price: ")
        val price = readLine()?.trim()?.toDoubleOrNull() ?: 0.0

        println()
        println("Select eligibility strategy:")
        println("  1 - AgeStrategy")
        println("  2 - PassportStrategy")
        print("Enter choice (1 or 2): ")
        val strategyChoice = readLine()?.trim()?.toIntOrNull() ?: 1

        println()

        val customer = Customer(name, age, hasPassport)
        val quotation = Quotation(price)
        val booking = quotation.accept()

        if (strategyChoice == 1) {
            booking.setStrategy(AgeStrategy())
        } else {
            booking.setStrategy(PassportStrategy())
        }

        booking.addObserver(LogObserver())
        booking.addObserver(EmailObserver())

        val isEligible = booking.verifyEligibility(customer)

        println()

        if (isEligible) {
            booking.confirm()
        } else {
            println("[BOOKING] Customer not eligible. Booking was NOT confirmed.")
        }

        println()
        print("Run another booking? (y/n): ")
        val again = readLine()?.trim()

        if (!again.equals("y", ignoreCase = true)) {
            running = false
        }
    }

    println()
    println("============================================================")
    println("                     SIMULATION COMPLETE                   ")
    println("============================================================")
}
