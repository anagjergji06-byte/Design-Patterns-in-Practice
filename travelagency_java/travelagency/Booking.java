package travelagency;
import java.util.ArrayList;
public class Booking {
    String status;
    double price;
    EligibilityStrategy strategy;
    ArrayList<BookingObserver> observers;
    public Booking(double price) {
        this.price = price;
        this.status = "Pending";
        this.observers = new ArrayList<BookingObserver>();
    }
    // Strategy: the eligibility rule is swappable at runtime; Booking never knows which rule it runs.
    public void setStrategy(EligibilityStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean verifyEligibility(Customer customer) {
        boolean result = this.strategy.validate(customer);
        if (result) {
            System.out.println("[BOOKING] Eligibility check PASSED for customer: " + customer.name);
        } else {
            System.out.println("[BOOKING] Eligibility check FAILED for customer: " + customer.name);
        }
        return result;
    }
    // Observer: any number of listeners can subscribe; confirm() notifies them all without knowing what they do.
    public void addObserver(BookingObserver observer) {
        this.observers.add(observer);
    }
    public void confirm() {
        this.status = "Confirmed";
        System.out.println("[BOOKING] Status updated to: " + this.status);
        for (BookingObserver observer : this.observers) {
            observer.update();
        }
    }
}
