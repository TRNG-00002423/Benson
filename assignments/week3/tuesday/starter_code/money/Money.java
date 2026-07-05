package money;
/**
 * TODO: immutable currency + amountMinor; equals/hashCode contract.
 */
import java.util.Objects;

public final class Money {
    // TODO fields, constructor validates currency non-null
    private final String currency;
    private final long amountMinor;

    Money(String currency, long amountMinor){
        if(currency == null){
            throw new IllegalArgumentException();
        }
        this.currency = currency;
        this.amountMinor = amountMinor;
    }
    
    public String getCurrency(){
        return this.currency;
    }

    public long getAmountMinor(){
        return this.amountMinor;
    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof Money){
            Money other = (Money) o;
            return other.amountMinor == this.amountMinor && other.currency.equals(this.currency);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency, this.amountMinor);
    }

    @Override
    public String toString() {
        return String.format("Currency: %s, amount minor: %s", this.currency, this.amountMinor);
    }
}