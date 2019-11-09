package phonebook.util.creator;

import phonebook.personalData.Person;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersonFileCreator {
    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static List<Person> fillPeopleList(Path path, boolean personWithNumber) throws IOException {
        List<Person> people = new ArrayList<>();
        for (String line : Files.readAllLines(path, ENCODING)) {
            if (!personWithNumber) {
                people.add(createPerson(line));
            } else {
                people.add(createPersonWithNumber(line));
            }
        }
        return people;
    }

    private static Person createPerson(String line) {
        String[] personData = line.split(" ");
        if (personData.length == 1) {
            return new Person(personData[0]);
        } else if (personData.length == 2) {
            return new Person(personData[0], personData[1]);
        }
        return new Person();
    }

    private static Person createPersonWithNumber(String line) {
        String[] personData = line.split(" ");
        if (personData.length == 2) {
            return new Person(personData[1], Long.parseLong(personData[0]));
        } else if (personData.length == 3) {
            return new Person(personData[1], personData[2], Long.parseLong(personData[0]));
        }
        return new Person();
    }
}
