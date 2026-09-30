package travelagency;
public class Quotation {
    double price;
    public Quotation(double price) {
        this.price = price;
    }
    // Factory: all Booking creation funnels through here, so booking subtypes or invoicing can be added without changing callers.
    public Booking accept() {
        Booking newBooking = new Booking(this.price);
        System.out.println("[QUOTATION] Quotation accepted. New booking created with price: $" + this.price);
        return newBooking;
    }
}
