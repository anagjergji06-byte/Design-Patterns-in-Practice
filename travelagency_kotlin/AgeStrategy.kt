class AgeStrategy : EligibilityStrategy {

    override fun validate(customer: Customer): Boolean {
        if (customer.age > 65) {
            println("[AGE CHECK] Customer is over 65. Eligibility passed.")
            return true
        }

        println("[AGE CHECK] Customer is not over 65. Eligibility failed.")
        return false
    }
}
