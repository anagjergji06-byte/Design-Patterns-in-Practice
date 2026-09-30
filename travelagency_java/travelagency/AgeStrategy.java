package travelagency;
public class AgeStrategy implements EligibilityStrategy {
    @Override
    public boolean validate(Customer customer) {
        if (customer.age > 65) {
            System.out.println("[AGE CHECK] Customer is over 65. Eligibility passed.");
            return true;
        }
        System.out.println("[AGE CHECK] Customer is not over 65. Eligibility failed.");
        return false;
    }
}
