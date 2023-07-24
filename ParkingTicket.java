import java.time.format.DateTimeFormatter;

public class ParkingTicket {
    private String enterDate;
    private String enterTime;
    private long cardNumber; // Use camelCase for variable names
    private String cardType;
    private int spotNumber;
    private Car car;

    public Car getAssignedCar() {
        return car;
    }

    public void setAssignedCar(Car car) {
        this.car = car;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
