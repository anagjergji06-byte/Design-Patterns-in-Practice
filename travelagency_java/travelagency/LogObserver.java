package travelagency;
public class LogObserver implements BookingObserver {
    @Override
    public void update() {
        System.out.println("[LOG] Booking status changed. Saved to history.");
    }
}
