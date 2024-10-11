import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

    MessagingApp app = new MessagingApp();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("1. Add Contact");
        System.out.println("2. Send Message");
        System.out.println("3. Search contact");
        System.out.println("4. Delete message");
        System.out.println("5. Display messages");
        System.out.println("6. Display contacts");
        System.out.println("7. Exit");

       int choice = scanner.nextInt();
       switch (choice) {
           case 1:
               app.addContact();
               break;
           case 2:
               app.sendMessage();
               break;
           case 3:
               app.Search();
               break;
           case 4:
               app.deleteMessage();
               break;
           case 5:
               app.displayMessages();
               break;
           case 6:
               app.displayContact();
               break;
           case 7:
               System.exit(0);
               break;
           default:
               System.out.println("Invalid choice");
       }

       }

        }
    }




