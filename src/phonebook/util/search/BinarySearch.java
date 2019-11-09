package phonebook.util.search;

import phonebook.personalData.Person;

import java.util.List;

public class BinarySearch extends Searcher {

    public BinarySearch(List<Person> phoneBookPeople, List<Person> peopleToBeFound) {
      super(phoneBookPeople, peopleToBeFound);
    }


    @Override
    public  void findPeople() {
        for (Person personToFound : peopleToBeFound) {
            int indexOfFoundPerson = binarySearch(phoneBookPeople, personToFound);
            if (indexOfFoundPerson != -1) {
                foundPeople.add(phoneBookPeople.get(indexOfFoundPerson));
                entriesFound++;
            }
        }
    }

    private  int binarySearch(List<Person> peoplePhoneBook, Person target) {
        return binarySearch(peoplePhoneBook, target, 0, peoplePhoneBook.size() - 1);
    }

    private int binarySearch(List<Person> peoplePhoneBook, Person target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        Person middlePerson = peoplePhoneBook.get(middle);
        if (target.equals(middlePerson)) {
            return middle;
        } else if (target.isInLexicographicalOrder(middlePerson)) {
            return binarySearch(peoplePhoneBook, target, left, middle - 1);
        } else {
            return binarySearch(peoplePhoneBook, target, middle + 1, right);
        }
    }

}
