package travelagency;
public class PassportStrategy implements EligibilityStrategy {
    @Override
    public boolean validate(Customer customer) {
        if (customer.hasPassport) {
            System.out.println("[PASSPORT CHECK] Customer has a valid passport. Eligibility passed.");
            return true;
        }
        System.out.println("[PASSPORT CHECK] Customer does not have a passport. Eligibility failed.");
        return false;
    }
}
