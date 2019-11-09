package phonebook.util;

public class CountTime {
    private static long startTime;
    public static void start(){
        startTime = System.currentTimeMillis();
    }

    public static String stop(){
        long endTime = System.currentTimeMillis();
        long timeInMillis = endTime - startTime;
        return printTimeInfo(timeInMillis);
    }

    public static String printTimeInfo(long timeInMillis){
        long milis = timeInMillis % 1000;
        timeInMillis -= milis;
        timeInMillis = timeInMillis / 1000;
        long min = timeInMillis / 60;
        long sec = timeInMillis - 60 * min;
        return min + " min. " + sec + " sec. " + milis + " ms.";
    }
}
