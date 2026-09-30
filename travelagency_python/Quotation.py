from Booking import Booking

class Quotation:
    def __init__(self, price):
        self.price = price

    # Factory: all Booking creation funnels through here, so booking subtypes or invoicing can be added without changing callers.
    def accept(self):
        booking = Booking()
        booking.price = self.price
        booking.status = "Pending"
        return booking