package phonebook.util.creator;

import phonebook.personalData.Person;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class PeopleReader {
    protected Path filePath;
    protected List<Person> people;

    PeopleReader(String pathToFile, boolean personWithNumber){
        this.filePath = Paths.get(pathToFile);
    }

    abstract void readPeople(boolean personWithNumber);

    public List<Person> getPeople(){
        return people;
    }

}
