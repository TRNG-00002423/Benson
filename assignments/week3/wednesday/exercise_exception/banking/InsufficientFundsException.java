package banking;

/** Checked — include shortfall. */
public class InsufficientFundsException extends Exception {
    private final double shortfall;
    public InsufficientFundsException(double shortfall) {
        super(String.format("Insufficient funds, shortfall: %f", shortfall));
        this.shortfall = shortfall;
    }
}