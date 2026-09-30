from Customer import Customer
from Quotation import Quotation
from Strategies import AgeStrategy, PassportStrategy
from Observers import LogObserver, EmailObserver

print("============================================================")
print("       TRAVEL AGENCY SIMULATOR - Python Implementation      ")
print("============================================================")

running = True

while running:

    print()
    name = input("Enter customer name: ")
    age = int(input("Enter customer age: "))
    hasPassport = input("Does customer have a passport? (true/false): ").strip().lower() == "true"
    price = float(input("Enter quotation price: "))

    print()
    print("Select eligibility strategy:")
    print("  1 - AgeStrategy")
    print("  2 - PassportStrategy")
    strategyChoice = int(input("Enter choice (1 or 2): "))

    print()

    customer = Customer(name, age, hasPassport)
    quotation = Quotation(price)
    booking = quotation.accept()

    if strategyChoice == 1:
        booking.set_strategy(AgeStrategy())
    else:
        booking.set_strategy(PassportStrategy())

    booking.add_observer(LogObserver())
    booking.add_observer(EmailObserver())

    isEligible = booking.verify_eligibility(customer)

    print()

    if isEligible:
        booking.confirm()
    else:
        print("[BOOKING] Customer not eligible. Booking was NOT confirmed.")

    print()
    again = input("Run another booking? (y/n): ")

    if again.strip().lower() != "y":
        running = False

print()
print("============================================================")
print("                     SIMULATION COMPLETE                   ")
print("============================================================")
