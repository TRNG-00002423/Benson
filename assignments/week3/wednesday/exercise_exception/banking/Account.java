package banking;

public class Account {
    // TODO fields: id, balance
    private final String id;
    private double balance;

    public Account(String id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount < 0){
            throw new IllegalArgumentException();
        }

        if(amount > this.balance){
            throw new InsufficientFundsException(amount - this.balance);
        }

        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    }
}