package phonebook.util.search;

import phonebook.personalData.Person;

import java.util.List;

public class LinearSearch extends Searcher {

    public LinearSearch(List<Person> phoneBookPeople, List<Person> peopleToBeFound) {
        super(phoneBookPeople, peopleToBeFound);
    }

    @Override
    public void findPeople() {
        for (Person personToFound : peopleToBeFound) {
            for (Person person : phoneBookPeople) {
                if (person.equals(personToFound)) {
                    foundPeople.add(person);
                    entriesFound++;
                    break;
                }
            }
        }
    }
}
