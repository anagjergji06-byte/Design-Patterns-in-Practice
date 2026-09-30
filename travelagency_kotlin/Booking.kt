class Booking() {

    var status: String = " "
    private var strategy: EligibilityStrategy? = null
    private val observers = mutableListOf<BookingObserver>()
    var price: Double = 0.0

    // Strategy: the eligibility rule is swappable at runtime; Booking never knows which rule it runs.
    fun setStrategy(strategy: EligibilityStrategy) {
        this.strategy = strategy
    }

    fun verifyEligibility(customer: Customer): Boolean {
        val result = strategy?.validate(customer) ?: false

        if (result) {
            println("[BOOKING] Eligibility check PASSED for customer: " + customer.name)
        } else {
            println("[BOOKING] Eligibility check FAILED for customer: " + customer.name)
        }

        return result
    }

    // Observer: any number of listeners can subscribe; confirm() notifies them all without knowing what they do.
    fun addObserver(observer: BookingObserver) {
        observers.add(observer)
    }

    fun confirm() {
        this.status = "Confirmed"
        println("[BOOKING] Status updated to: " + this.status)

        var i = 0
        while (i < observers.size) {
            observers[i].update()
            i++
        }
    }
}
