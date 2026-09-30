class Quotation {

    // data fields
    var price: Double = 0.0

    // functions
    // Factory: all Booking creation funnels through here, so booking subtypes or invoicing can be added without changing callers.
    fun accept(): Booking {
        val booking = Booking()
        booking.price = price
        booking.status = "Pending"
        return booking
    }

    // constructor
    constructor(price: Double) {
        this.price = price
    }

}