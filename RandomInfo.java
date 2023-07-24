import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class RandomInfo {
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public String generateNumberPlate() {
        System.out.println("Enter state:");
        String state = scan.next();
        System.out.println("Enter district code:");
        int districtCode = scan.nextInt();
        System.out.println("Enter alpha code:");
        String alphaCode = scan.next();
        System.out.println("Enter the number:");
        int num = scan.nextInt();
        scan.nextLine(); // Consume the remaining newline character
        return state + "-" + districtCode + " " + alphaCode + " " + num;
    }

    public String getCarColor(String color) {
        
        return color;
    }

    public String getCarType(String cartype) {
        
        return cartype;
    }

    public String getTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        return localTime.format(dateTimeFormatter);
    }

    public String getDate() {
        LocalDate mydate = LocalDate.now();
        return mydate.toString();
    }

    public String getExitDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    public String getExitTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        return localTime.format(dateTimeFormatter);
    }
}
