package banking;
import java.util.HashMap;

public class Bank {
    // TODO HashMap<String, Account>
    private HashMap<String, Account> accounts = new HashMap<>();

    public void openAccount(String id, double initialDeposit) throws InvalidAccountException {
        if(this.accounts.containsKey(id)){
            throw new InvalidAccountException("Invalid id: ", id);
        }
        accounts.put(id, new Account(id, initialDeposit));
    }

    public Account getAccount(String id) throws InvalidAccountException {
        if(!this.accounts.containsKey(id)){
            throw new InvalidAccountException("Unknown id: ", id);
        }
        return this.accounts.get(id);
    }

    public void transfer(String fromId, String toId, double amount)
            throws InvalidAccountException, InsufficientFundsException {
        if(!this.accounts.containsKey(fromId)){
            throw new InvalidAccountException("Invalid from id: ", fromId);
        }
        if(!this.accounts.containsKey(toId)){
            throw new InvalidAccountException("Invalid to id: ", toId);
        }

        if(amount < 0){
            throw new IllegalArgumentException();
        }

        Account toAccount = this.accounts.get(toId);
        Account fromAccount = this.accounts.get(fromId);
        
        try{
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }catch(IllegalArgumentException | InsufficientFundsException e){
            System.out.println(e);
        }

    }
}