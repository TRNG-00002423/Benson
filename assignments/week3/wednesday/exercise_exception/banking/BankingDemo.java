package banking;

public class BankingDemo {
    public static void main(String[] args) throws Exception {
        // TODO: demonstrate success path + catch InsufficientFundsException + InvalidAccountException
        // TODO: trigger IllegalArgumentException on bad deposit
        Bank bank = new Bank();
        successPath(bank);
        invalidIdPath(bank);
        insufficientFundsPath(bank);
        illegalArgumentPath(bank);
    }

    public static void successPath(Bank bank){
        System.out.println("Sucess path: ");
        try{
            bank.openAccount("1", 1000);
            bank.openAccount("2", 1000);
            System.out.println("Account 1, initial deposit: 1000");
            System.out.println("Account 2, initial deposit: 1000");
            System.out.println("Transferring 500 from account 1 to 2");
            bank.transfer("1", "2", 500);
            System.out.println(String.format("Account 1: %.2f", bank.getAccount("1").getBalance()));
            System.out.println(String.format("Account 2: %.2f", bank.getAccount("2").getBalance()));
            System.out.println("-".repeat(20));
        }catch(InvalidAccountException | InsufficientFundsException e){
            System.out.println(e);
        }
    }

    public static void invalidIdPath(Bank bank){
        System.out.println("Invalid id path path: ");
        try{
            System.out.println("Transferring 500 from account 1 to 3");
            bank.transfer("1", "3", 500);
            System.out.println(String.format("Account 1: %.2f", bank.getAccount("1").getBalance()));
            System.out.println(String.format("Account 2: %.2f", bank.getAccount("2").getBalance()));
            System.out.println("-".repeat(20));
        }catch(InvalidAccountException | InsufficientFundsException e){
            System.out.println(e);
        }
    }

    public static void insufficientFundsPath(Bank bank){
        System.out.println("Insufficient funds path: ");
        try{
            System.out.println("Transferring 600 from account 1 to 2");
            bank.transfer("1", "2", 600);
            System.out.println(String.format("Account 1: %.2f", bank.getAccount("1").getBalance()));
            System.out.println(String.format("Account 2: %.2f", bank.getAccount("2").getBalance()));
            System.out.println("-".repeat(20));
        }catch(InvalidAccountException | InsufficientFundsException e){
            System.out.println(e);
        }
    }

    public static void illegalArgumentPath(Bank bank){
        System.out.println("Illegal argument path: ");
        try{
            System.out.println("Transferring -100 from account 1 to 2");
            bank.transfer("1", "2", -100);
            System.out.println(String.format("Account 1: %.2f", bank.getAccount("1").getBalance()));
            System.out.println(String.format("Account 2: %.2f", bank.getAccount("2").getBalance()));
            System.out.println("-".repeat(20));
        }catch(InvalidAccountException | InsufficientFundsException e){
            System.out.println(e);
        }
    }
}