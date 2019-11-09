package phonebook.util.search;

import phonebook.personalData.Person;

import java.util.Hashtable;
import java.util.List;

public class HashingSearch<K,V> extends Hashtable implements ISearcher{
    private List<Person> phoneBookPeople;
    private List<Person> peopleToFound;
    private int entriesFound;

    public HashingSearch(List<Person> phoneBookPeople, List<Person> peopleToFound){
        super();
        this.phoneBookPeople = phoneBookPeople;
        this.peopleToFound = peopleToFound;
        this.entriesFound = 0;
    }
    
    public void putAllPeople() {
        for (Person person : phoneBookPeople) {
            this.put(person.getName() + " " + person.getSurname(), person.getPhoneNumber());
        }
    }


    @Override
    public int getEntriesFound() {
        return entriesFound;
    }

    @Override
    public void findPeople() {
        for (Person person : peopleToFound) {
            if (this.containsKey(person.getName() + " " + person.getSurname())) {
                entriesFound++;
            }
        }
    }
}
