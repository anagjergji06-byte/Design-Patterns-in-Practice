class EligibilityStrategy:
    def validate(self, customer):
        pass

class AgeStrategy(EligibilityStrategy):
    def validate(self, customer):
        if customer.age > 65:
            print("[AGE CHECK] Customer is over 65. Eligibility passed.")
            return True

        print("[AGE CHECK] Customer is not over 65. Eligibility failed.")
        return False

class PassportStrategy(EligibilityStrategy):
    def validate(self, customer):
        if customer.hasPassport:
            print("[PASSPORT CHECK] Customer has a valid passport. Eligibility passed.")
            return True

        print("[PASSPORT CHECK] Customer does not have a passport. Eligibility failed.")
        return False
