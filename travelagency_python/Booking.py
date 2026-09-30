class Booking:
    def __init__(self):
        self.status = " "
        self.price = 0.0
        self.strategy = None
        self.observers = []

    # Strategy: the eligibility rule is swappable at runtime; Booking never knows which rule it runs.
    def set_strategy(self, strategy):
        self.strategy = strategy

    # Observer: any number of listeners can subscribe; confirm() notifies them all without knowing what they do.
    def add_observer(self, observer):
        self.observers.append(observer)

    def verify_eligibility(self, customer):
        result = self.strategy.validate(customer) if self.strategy else False

        if result:
            print("[BOOKING] Eligibility check PASSED for customer: " + customer.name)
        else:
            print("[BOOKING] Eligibility check FAILED for customer: " + customer.name)

        return result

    def confirm(self):
        self.status = "Confirmed"
        print("[BOOKING] Status updated to: " + self.status)

        for observer in self.observers:
            observer.update()
