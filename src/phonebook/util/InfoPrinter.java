package phonebook.util;

public class InfoPrinter {

    public static void startSearchInfo(String searchType) {
        System.out.println("Start searching (" + searchType + ")...");
    }

    public static void startSearchInfo(String searchType, String sortType) {
        System.out.println("Start searching (" + sortType + " + " + searchType + ")...");
    }

    public static void foundInfo(int entriesFound, int entriesToFound, long timeTaken) {
        System.out.println("Found " + entriesFound + " / " + entriesToFound + " entries. Time taken: " + CountTime.printTimeInfo(timeTaken));
    }

    public static void foundInfo(int entriesFound, int entriesToFound) {
        System.out.println("Found " + entriesFound + " / " + entriesToFound + " entries. Time taken: " + CountTime.stop());
    }

    public static void sortingInfo(long sortingTime) {
        System.out.println("Sorting time: " + CountTime.printTimeInfo(sortingTime));
    }

    public static void creatingTime(long sortingTime) {
        System.out.println("Creating time: " + CountTime.printTimeInfo(sortingTime));
    }

    public static void sortingInfo(long sortingTime, boolean isSortingSucceed) {
        System.out.print("Sorting time: " + CountTime.printTimeInfo(sortingTime));
        if (!isSortingSucceed) {
            System.out.println(" - STOPPED, moved to linear search");
        } else {
            System.out.println();
        }
    }

    public static void searchingInfo(long searchingTime) {
        System.out.println("Searching time:" + CountTime.printTimeInfo(searchingTime));
    }
}
