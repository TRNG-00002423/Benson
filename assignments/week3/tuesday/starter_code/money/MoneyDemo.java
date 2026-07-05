package money;
import java.util.HashSet;

public class MoneyDemo {
    public static void main(String[] args) {
        // TODO: build Money USD 1000 cents twice, add to HashSet, print size
        // TODO: print equals vs ==

        Money m1 = new Money("USD", 1000);
        Money m2 = new Money("USD", 1000);

        HashSet<Money> moneySet = new HashSet<>();
        moneySet.add(m1);
        moneySet.add(m2);

        for(Money money: moneySet){
            System.out.println(money);
        }
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));

    }
}