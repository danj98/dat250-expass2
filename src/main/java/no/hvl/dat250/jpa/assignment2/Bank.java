package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private Set<CreditCard> ownedCards;

    public Bank() {
        ownedCards = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCards(CreditCard card) {
        this.ownedCards.add(card);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }
}
