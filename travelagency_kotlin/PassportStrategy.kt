class PassportStrategy : EligibilityStrategy {

    override fun validate(customer: Customer): Boolean {
        if (customer.hasPassport) {
            println("[PASSPORT CHECK] Customer has a valid passport. Eligibility passed.")
            return true
        }

        println("[PASSPORT CHECK] Customer does not have a passport. Eligibility failed.")
        return false
    }
}
