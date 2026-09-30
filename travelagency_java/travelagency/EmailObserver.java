package travelagency;
public class EmailObserver implements BookingObserver {
    @Override
    public void update() {
        System.out.println("[EMAIL] Booking confirmed! Message sent to customer.");
    }
}
