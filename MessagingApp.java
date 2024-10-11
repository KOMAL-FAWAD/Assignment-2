import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class MessagingApp {
    Messages[] messages = new Messages[100];
    String contacts[][] = new String[100][2];
    Messages chats[][] = new Messages[100][100];
    static int contactcounter = 0;
    static int messagecounter = 0;
    int chatcounter[] = new int[100];

    {

        contacts[contactcounter++] = new String[]{"Maham", "03001258963"};
        contacts[contactcounter++] = new String[]{"Maryam", "03256314852"};
        contacts[contactcounter++] = new String[]{"Huma", "03486321452"};
        contacts[contactcounter++] = new String[]{"Sadaf", "03102589631"};
    }


    public void sendMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.nextLine();

        boolean contactFound = false;
        for (int i = 0; i < contactcounter; i++) {
            if (name.equals(contacts[i][0])) {
                contactFound = true;

                System.out.println("Enter Message  : ");
                String message = sc.nextLine();

                Messages newMessage = new Messages(name, message);

                chats[i][chatcounter[i]] = newMessage;
                chatcounter[i]++;

                System.out.println("Message sent");
            }

            }
            if(!contactFound) {
            System.out.println("Name not found");
        }

        }


    public void Search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.nextLine();

        boolean contactFound = false;

        for (int i = 0; i < contactcounter; i++) {
            if (name.equals(contacts[i][0])) {
                contactFound = true;
                System.out.println("Contact found!");
                System.out.println("Name : " + contacts[i][0]);
                System.out.println("Number : " + contacts[i][1]);
                for (int j = 0; j < chatcounter[i]; j++) {
                    if (chats[i][j] != null) {
                        System.out.println(chats[i][j]);
                    }
                }
                break;
                }
            }
        if (!contactFound) {
            System.out.println("Contact not found");
        }

    }


       public void displayMessagesByTime(Messages[] messages) {
//           Scanner sc = new Scanner(System.in);
//           System.out.println("Enter Name : ");
//           String name = sc.nextLine();
//           boolean contactFound = false;
//
//           for (int i = 0; i < contactcounter; i++) {
//               if (name.equals(contacts[i][0])) {
//                   contactFound = true;
//
//
//                   System.out.println("Enter start time : ");
//                   String startTime = sc.nextLine();
//                   System.out.println("Enter end time : ");
//                   String endTime = sc.nextLine();
//                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//                   LocalDateTime start = LocalDateTime.parse(startTime, formatter);
//                   LocalDateTime end = LocalDateTime.parse(endTime, formatter);
//                   for (int j = 0; j < chatcounter[i]; j++) {
//                       Messages sms = chats[i][j];
//                       if (sms != null && sms.getSendername().equals(name) && sms.getDateTime().isAfter(start) ||
//                               sms.getDateTime().isEqual(start) && sms.getDateTime().isBefore(end) || sms.getDateTime().isEqual(end)) {
//                           System.out.println(sms);
//
//                       }
//
//                   }
//
//
//               } else {
//                   System.out.println("Name not found");
//               }
//
//           }

           int n = messages.length;
           for (int i = 0; i < n-1; i++) {
               for (int j = 0; j < n-i-1; j++) {
                   if(messages[j].getDateTime().isBefore(messages[j+1].getDateTime())) {
                       Messages temp = messages[j];
                       messages[j] = messages[j+1];
                       messages[j+1] = temp;
                   }
               }

           }
    }


    public void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Message Id to delete : ");
        int messageId = Integer.parseInt(sc.nextLine());

        boolean messageFound = false;

        for (int i = 0; i < messagecounter; i++) {
            if (messages[i] != null && messages[i].getMessageid() == messageId) {
                    messages[i].setContent(null);
                    messages[i] = null;
                    System.out.println("Message deleted!");
                    messageFound = true;

            }
        }
        if (!messageFound) {
            System.out.println("Message not found");
        }
    }

    public void addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Contact Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Number : ");
        String number = sc.nextLine();
        contacts[contactcounter][0] = name;
        contacts[contactcounter][1] = number;
        contactcounter++;
        System.out.println(contactcounter);
        System.out.println("Contact Added");
        System.out.println(name);
        System.out.println(number);
        System.out.println("----------------");

    }

//    public void UnseenMessages() {
//        boolean hasSeen = false;
//        System.out.println("Unseen Messages : ");
//
//        for (int i = 0; i < messagecounter; i++) {
//            Messages sms = messages[i];
//            if (!sms.isStatus()) {
//                System.out.println(messages[i]);
//                hasSeen = true;
//            }
//        }
//        if (!hasSeen) {
//            System.out.println("No Unseen Messages");
//        }
//    }
//    public void SeenMessages(){
//        boolean hasSeen = false;
//
//        for(int i = 0; i < messagecounter; i++) {
//            Messages sms = messages[i];
//            if(sms.isStatus()) {
//                System.out.println(sms);
//                hasSeen = true;
//
//            }
//        }
//        if (!hasSeen) {
//            System.out.println("No Seen Messages");
//        }
//    }

    public void displayMessages() {
        if (messagecounter == 0) {
            System.out.println("No Messages");
            return;
        }

        System.out.println("Displaying Messages : ");
        for (int i = 0; i < contactcounter; i++) {

//            Messages[] messages = Arrays.copyOf(chats[i], chatcounter[i]);
//            displayMessagesByTime(messages);
            if(chatcounter[i] == 0){
                continue;
            }
            System.out.println(contacts[i][0]);

            for (int j = 0; j < chatcounter[i]; j++) {
                if (chats[i][j] != null) {
                    System.out.println(chats[i][j].getMessageid());
                    System.out.println(chats[i][j].getReceivername());
                    System.out.println(chats[i][j].getContent());
                    System.out.println(chats[i][j].getDateTime());
                    System.out.println(chats[i][j].isStatus() ? "Seen" : "Unseen");
                    System.out.println("--------------------------");
                }
            }
        }
    }
    public void displayContact(){
        if(contactcounter==0){
            System.out.println("No contacts");
        }

        System.out.println("Displaying Contact : ");
        for (int i = 0; i < contactcounter; i++) {
            if(contacts[i][0] != null) {
                System.out.println("Name : "+contacts[i][0]);
                System.out.println("Number : "+contacts[i][1]);
                System.out.println("------------------");
            }
        }
    }
}

