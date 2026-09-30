class BookingObserver:
    def update(self):
        pass

class EmailObserver(BookingObserver):
    def update(self):
        print("[EMAIL] Booking confirmed! Message sent to customer.")

class LogObserver(BookingObserver):
    def update(self):
        print("[LOG] Booking status changed. Saved to history.")