
public class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount > balance){
            double shortfall = amount - balance;
            throw new InsufficientFundsException(shortfall);
        }else{
            this.balance -= amount;
        }
    }
}
