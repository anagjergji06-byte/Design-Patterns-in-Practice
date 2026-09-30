class LogObserver : BookingObserver {

    override fun update() {
        println("[LOG] Booking status changed. Saved to history.")
    }
}
