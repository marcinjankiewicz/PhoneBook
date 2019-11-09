package phonebook.util.creator;

import java.io.IOException;

public class People extends PeopleReader {

    public People(String pathToFile, boolean personWithNumber) {
        super(pathToFile, personWithNumber);
        readPeople(personWithNumber);
    }

    @Override
    void readPeople(boolean personWithNumber) {
        try {
            people = PersonFileCreator.fillPeopleList(filePath, personWithNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
