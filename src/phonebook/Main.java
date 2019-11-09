package phonebook;


import phonebook.personalData.Person;
import phonebook.util.CountTime;
import phonebook.util.InfoPrinter;
import phonebook.util.creator.People;
import phonebook.util.search.*;
import phonebook.util.sort.BubbleSort;
import phonebook.util.sort.QuickSort;
import phonebook.util.sort.Sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String PATH_DIRECTORY = "resources/directory.txt";
    private static final String PATH_FIND = "resources/find.txt";

    private long timeLinearSearch;

    public static void main(String[] args) {
        Main main = new Main();
        main.measureLinearSearch();
        System.out.println();
        main.measureBubbleSortAndJumpSearch();
        System.out.println();
        main.measureQuickSortAndBinarySearch();
        System.out.println();
        main.measureHashTable();
    }

    private void measureLinearSearch() {
        long startLinearSearch = System.currentTimeMillis();
        Searcher search = new LinearSearch((new People(PATH_DIRECTORY, true)).getPeople(), (new People(PATH_FIND, false)).getPeople());
        search.findPeople();
        InfoPrinter.startSearchInfo(search.getClass().getSimpleName());
        this.timeLinearSearch = System.currentTimeMillis() - startLinearSearch;
        InfoPrinter.foundInfo(search.getEntriesFound(), 500, this.timeLinearSearch);
    }

    private void measureBubbleSortAndJumpSearch() {
        CountTime.start();
        BubbleSort sort = new BubbleSort(this.timeLinearSearch * 10L);
        People peoplePhoneBook = new People(PATH_DIRECTORY, true);
        People peopleToFound = new People(PATH_FIND, false);
        Searcher searcher = new JumpSearch(peoplePhoneBook.getPeople(), peopleToFound.getPeople());
        InfoPrinter.startSearchInfo(searcher.getClass().getSimpleName(), sort.getClass().getSimpleName());
        long sortingTimeStart = System.currentTimeMillis();
        sort.sort(peoplePhoneBook.getPeople());
        long sortingTime = System.currentTimeMillis() - sortingTimeStart;
        long searchingTimeStart = System.currentTimeMillis();
        if (sort.isSortingSucceed()) {
            ((Searcher)searcher).findPeople();
        } else {
            searcher = new LinearSearch(peoplePhoneBook.getPeople(), peopleToFound.getPeople());
            ((Searcher)searcher).findPeople();
        }

        long searchingTime = System.currentTimeMillis() - searchingTimeStart;
        InfoPrinter.foundInfo(((Searcher)searcher).getEntriesFound(), peopleToFound.getPeople().size());
        InfoPrinter.sortingInfo(sortingTime, sort.isSortingSucceed());
        InfoPrinter.searchingInfo(searchingTime);
    }

    private void measureQuickSortAndBinarySearch() {
        CountTime.start();
        Sort sort = new QuickSort();
        People peoplePhoneBook = new People(PATH_DIRECTORY, true);
        People peopleToFound = new People(PATH_FIND, false);
        Searcher searcher = new BinarySearch(peoplePhoneBook.getPeople(), peopleToFound.getPeople());
        InfoPrinter.startSearchInfo(searcher.getClass().getSimpleName(), sort.getClass().getSimpleName());
        long sortingTimeStart = System.currentTimeMillis();
        sort.sort(peoplePhoneBook.getPeople());
        long sortingTime = System.currentTimeMillis() - sortingTimeStart;
        long searchingTimeStart = System.currentTimeMillis();
        searcher.findPeople();
        long searchingTime = System.currentTimeMillis() - searchingTimeStart;
        InfoPrinter.foundInfo(searcher.getEntriesFound(), peopleToFound.getPeople().size());
        InfoPrinter.sortingInfo(sortingTime);
        InfoPrinter.searchingInfo(searchingTime);
    }

    private void measureHashTable() {
        CountTime.start();
        People peoplePhoneBook = new People(PATH_DIRECTORY, true);
        People peopleToFound = new People(PATH_FIND, false);
        HashingSearch<String, Long> hashtable = new HashingSearch(peoplePhoneBook.getPeople(), peopleToFound.getPeople());
        InfoPrinter.startSearchInfo(hashtable.getClass().getSimpleName());
        long creatingTimeStart = System.currentTimeMillis();
        hashtable.putAllPeople();
        long creatingTime = System.currentTimeMillis() - creatingTimeStart;
        long searchingTimeStart = System.currentTimeMillis();
        hashtable.findPeople();
        long searchingTime = System.currentTimeMillis() - searchingTimeStart;
        InfoPrinter.foundInfo(hashtable.getEntriesFound(), peopleToFound.getPeople().size());
        InfoPrinter.creatingTime(creatingTime);
        InfoPrinter.searchingInfo(searchingTime);
    }

    private static void saveFile(List<Person> people, String path) {
        try (FileWriter fw = new FileWriter(path);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Person person : people) {
                bw.write(person.getPhoneNumber() + " " +
                        person.getName() + " " +
                        person.getSurname());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
