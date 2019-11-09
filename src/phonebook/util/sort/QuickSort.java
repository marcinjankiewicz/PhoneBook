package phonebook.util.sort;

import phonebook.personalData.Person;

import java.util.List;

public class QuickSort implements Sort {

    @Override
    public void sort(List<Person> people) {
        sort(people, 0, people.size() - 1);
    }

    private void sort(List<Person> people, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(people, left, right);
            sort(people, left, pivotIndex - 1);
            sort(people, pivotIndex + 1, right);
        }
    }

    private int partition(List<Person> people, int left, int right) {
        Person pivot = people.get(right);
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (people.get(i).isInLexicographicalOrder(pivot)) {
                swap(people, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(people, partitionIndex, right);
        return partitionIndex;
    }

    private void swap(List<Person> people, int i, int j) {
        Person temp = people.get(i);
        people.set(i, people.get(j));
        people.set(j, temp);
    }
}
