package phonebook.personalData;


import java.util.Objects;

public class Person implements Comparable {
    private String name;
    private String surname;
    private long phoneNumber;

    public Person(String name, String surname, long phoneNumber) {
        this(name, phoneNumber);
        this.surname = surname;
    }

    public Person(String name, long phoneNumber) {
        this(name);
        this.phoneNumber = phoneNumber;
    }

    public Person(String name, String surname) {
        this(name);
        this.surname = surname;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    /**
     *
     * @param o
     * @return {@code 0} if this person has the same name and surname as the person compered to
     * less than {@code 0} if this person has name and surname lexicographically less than the person compered to
     * more than {@code 0} if this person has name and surname lexicographically more than the person compered to
     */
    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return (name + " " + surname).compareTo(person.name + " " + person.surname);
    }

    /**
     *
     * @param person
     * @return {@code true} if this person is in alphabetical order compered to the person or has the same name and surname
     * {@code false} if this person in not in alphabetical order compered to the person
     */

    public boolean isInLexicographicalOrder(Person person){
        int comparator = compareTo(person);
        return comparator <= 0;
    }
}
