import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RecordBreaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 1; i <= cases; i++) {
            System.out.println(String.format("Case #%d: %d", i, getBreakingDays(sc)));
        }
    }

    static int getBreakingDays (Scanner sc) {
        int recordBreaksCount = 0;
        int previousRecord = 0;
        int days = sc.nextInt();
        int[] visitors = new int[days];
        for (int i = 0; i < days; i++) {
            visitors[i] = sc.nextInt();
        }
        for (int i = 0; i < days; i++) {
            boolean greaterThanPreviousDays = (i == 0) || (visitors[i] > previousRecord);
            boolean greaterThanFollowingDays = (i == days - 1) || (visitors[i] > visitors[i + 1]);
            if (greaterThanPreviousDays && greaterThanFollowingDays) {
                recordBreaksCount++;
            }
            previousRecord = Math.max(previousRecord, visitors[i]);
        }
        return recordBreaksCount;
    }
}