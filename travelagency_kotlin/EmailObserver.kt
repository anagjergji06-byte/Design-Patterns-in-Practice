class EmailObserver : BookingObserver {

    override fun update() {
        println("[EMAIL] Booking confirmed! Message sent to customer.")
    }
}
