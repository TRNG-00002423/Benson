import java.util.Scanner;

/**
 * Week 2 Exercise — menu-driven console (implement the menu loop).
 *
 * Compile: javac TicketMenu.java
 * Run:     java TicketMenu
 */
public class TicketMenu {

    public static void main(String[] args) {
        String[] tickets = {"BUG-101 Login timeout", "BUG-102 CSV import", "BUG-103 flaky assertion"};
        int[] priorities = {2, 2, 2}; // stretch: update in menu option 2

        try (Scanner in = new Scanner(System.in)) {
            // TODO: loop until quit
            // print menu: 1=list 2=set priority 3=summary 4=quit
            System.out.println("Implement TicketMenu loop");
            while (true) { 
                System.out.println("print menu: 1=list 2=set priority 3=summary 4=quit");
                String user_input = in.nextLine();

                switch(user_input){
                    case "1" -> {
                        for(int i = 0; i < tickets.length; i++){
                            System.out.printf("%d Ticket: %s, priority: %d%n", i, tickets[i], priorities[i]);
                        }
                    }
                    case "2" -> {
                        System.out.println("Enter ticket index and priority");
                        String caseTwoInput = in.nextLine();
                        String[] parts = caseTwoInput.split(" ");

                        try {
                            int ticketIndex = Integer.parseInt(parts[0]);
                            int priority = Integer.parseInt(parts[1]);
                            boolean error = false;

                            if(ticketIndex < 0 || ticketIndex >= tickets.length){
                                System.out.println("Invalid ticket index");
                                error = true;
                            }

                            if(priority <= 0 || priority > 3){
                                System.out.println("Invalid priority");
                                error = true;
                            }

                            if(error) break;

                            priorities[ticketIndex] = priority;

                        }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                            System.out.println("Invalid input");
                        }

                    }
                    case "3" -> {
                        int count = tickets.length;
                        System.out.println("You have " + count + " " + (count == 1 ? "ticket" : "tickets"));
                    }
                    case "4" -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option, try again");
                    }
                    
                }
            }
        }
    }
}