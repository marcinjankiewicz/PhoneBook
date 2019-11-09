package phonebook.util.search;

import phonebook.personalData.Person;

import java.util.List;

public class JumpSearch extends Searcher {

    public JumpSearch(List<Person> phoneBookPeople, List<Person> peopleToBeFound) {
        super(phoneBookPeople, peopleToBeFound);
    }

    private int jumpSearch(List<Person> people, Person target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block

        /* If array is empty, the element is not found */
        if (people.size() == 0) {
            return -1;
        }

        /* Check the first element */
        if (people.get(currentRight).equals(target)) {
            return 0;
        }

        /* Calculating the jump length over array elements */
        int jumpLength = (int) Math.sqrt(people.size());

        /* Finding a block where the element may be present */
        while (currentRight < people.size() - 1) {

            /* Calculating the right border of the following block */
            currentRight = Math.min(people.size() - 1, currentRight + jumpLength);

            if (people.get(currentRight).compareTo(target) > 0) {
                break; // Found a block that may contain the target element
            }

            prevRight = currentRight; // update the previous right block border
        }

        /* If the last block is reached and it cannot contain the target value => not found */
        if ((currentRight == people.size() - 1) && !target.equals(people.get(currentRight))) {
            return -1;
        }

        /* Doing linear search in the found block */
        return backwardSearch(people, target, prevRight, currentRight);
    }

    private int backwardSearch(List<Person> people, Person target, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (people.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void findPeople() {
        for (Person personToFound : peopleToBeFound) {
            int indexOfFoundPerson = jumpSearch(phoneBookPeople, personToFound);
            if (indexOfFoundPerson != -1) {
                foundPeople.add(phoneBookPeople.get(indexOfFoundPerson));
                entriesFound++;
            }
        }
    }

}
