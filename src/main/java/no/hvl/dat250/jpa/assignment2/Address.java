package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;
    @ManyToMany
    private Set<Person> owners;

    public Address() {
        owners = new HashSet<>();
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void addPerson(Person person) {
        owners.add(person);
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public Collection<Person> getOwners() {
        return owners;
    }
}
