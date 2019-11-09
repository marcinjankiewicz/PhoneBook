package phonebook.util.sort;

import phonebook.personalData.Person;

import java.util.List;

public class BubbleSort implements Sort {
    private long limitTime;
    private boolean sortingSucceed = true;

    public BubbleSort(long limitTime) {
        this.limitTime = limitTime;
    }

    @Override
    public void sort(List<Person> people) {
        long startTimeSorting = System.currentTimeMillis();
        boolean isSwapped;
        for (int i = 0; i < people.size() - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < people.size() - i - 1; j++) {
                int comparator = people.get(j).compareTo(people.get(j + 1));
                if (comparator > 0) {
                    Person tempPerson = people.get(j + 1);
                    people.set(j + 1, people.get(j));
                    people.set(j, tempPerson);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
            if (System.currentTimeMillis() - startTimeSorting > limitTime) {
                sortingSucceed = false;
                break;
            }
        }
    }

    public boolean isSortingSucceed() {
        return sortingSucceed;
    }
}
