
public class InsufficientFundsException extends Exception{
    private final double shortfall;
    public InsufficientFundsException(double shortfall){
        super(String.format("Shortfall: %f", shortfall));
        this.shortfall = shortfall;
    }
}
-