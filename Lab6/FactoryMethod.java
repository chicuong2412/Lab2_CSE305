package Lab6;

import java.util.Scanner;

public class FactoryMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose priority: (LOW/MEDIUM/HIGH)");
        String requestType = sc.nextLine().toLowerCase();

        RequestCreator requestCreator = null;

        switch (requestType) {
            case "low":
                requestCreator = new LowPriorityCreator();
                break;
            case "mid":
                requestCreator = new MidPriorityCreator();
                break;
            case "high":
                requestCreator = new HighPriorityCreator();
                break;
            default:
                System.out.println("Invalid request type!");
                sc.close();
                break;
        }

        requestCreator.createRequest().processRequest();;

    }
}
