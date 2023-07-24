public class Payment {
    private final static float hourAmount = 30;
    private final static float amountPerMinute = 10;
    private final static float amountPer15Minutes = 15;
    private final static float amountPer30Minutes = 20;

    public static float calculateTotalAmount(int hours, int minutes) {
        float totalAmountForHour = hours * hourAmount;
        float totalAmountForMinutes;

        if (minutes >= 30) {
            totalAmountForMinutes = amountPer30Minutes;
        } else if (minutes >= 15) {
            totalAmountForMinutes = amountPer15Minutes;
        } else if (minutes >= 1) {
            totalAmountForMinutes = amountPerMinute;
        } else {
            totalAmountForMinutes = 0;
        }

        return totalAmountForHour + totalAmountForMinutes;
    }
}
