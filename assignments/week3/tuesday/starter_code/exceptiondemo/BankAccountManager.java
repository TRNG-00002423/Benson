
public class BankAccountManager {
    public static void main(String[] args){
        BankAccount b = new BankAccount(1000);

        try{
            b.withdraw(1100);
        }catch(InsufficientFundsException e){
            System.out.println(e);
        }
    }
}
