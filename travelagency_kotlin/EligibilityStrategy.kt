interface EligibilityStrategy {

    fun validate(customer: Customer): Boolean
}
