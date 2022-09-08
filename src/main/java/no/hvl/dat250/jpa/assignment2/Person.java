package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private Collection<Address> addresses;
    @OneToMany
    private Collection<CreditCard> creditCards;

    public Person(){
        addresses = new ArrayList<>();
        creditCards = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAddresses(Address address) {
        addresses.add(address);
    }

    public void addCreditCards(CreditCard card) {
        creditCards.add(card);
    }


    public String getName() {
        return name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }
}
