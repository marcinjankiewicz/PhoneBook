package phonebook.util.search;

import phonebook.personalData.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class Searcher implements ISearcher{
    protected int entriesFound;
    protected List<Person> foundPeople;
    protected List<Person> phoneBookPeople;
    protected List<Person> peopleToBeFound;

    public Searcher(List<Person> phoneBookPeople, List<Person> peopleToBeFound) {
        this.foundPeople = new ArrayList<>();
        this.phoneBookPeople = phoneBookPeople;
        this.peopleToBeFound = peopleToBeFound;
    }

    public abstract void findPeople();

    public int getEntriesFound(){
        return entriesFound;
    }


    public List<Person> getPhoneBookPeople() {
        return phoneBookPeople;
    }

    public void setPhoneBookPeople(List<Person> phoneBookPeople) {
        this.phoneBookPeople = phoneBookPeople;
    }

    public List<Person> getFoundPeople() {
        return foundPeople;
    }

}
