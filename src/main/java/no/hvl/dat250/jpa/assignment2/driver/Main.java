package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // TODO: Persist object world corresponding to the domain model of experiment 2.
        EntityTransaction tx = em.getTransaction();
        Person person = new Person();
        person.setName("Max Mustermann");

        Address address = new Address();
        address.setNumber(28);
        address.setStreet("Inndalsveien");
        address.addPerson(person);

        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        person.addAddresses(address);

        Pincode pin = new Pincode();
        pin.setPincode("123");
        pin.setCount(1);

        Bank bank = new Bank();
        bank.setName("Pengebank");

        CreditCard c1 = new CreditCard();
        c1.setNumber(12345);
        c1.setBalance(-5000);
        c1.setLimit(-10000);
        c1.setPincode(pin);
        c1.setOwningBank(bank);

        CreditCard c2 = new CreditCard();
        c2.setNumber(123);
        c2.setBalance(1);
        c2.setLimit(2000);
        c2.setPincode(pin);
        c2.setOwningBank(bank);

        person.addCreditCards(c1);
        person.addCreditCards(c2);
        bank.addCards(c1);
        bank.addCards(c2);



        tx.begin();
        em.persist(person);
        em.persist(address);
        em.persist(c1);
        em.persist(c2);
        em.persist(pin);
        em.persist(bank);
        tx.commit();
        em.close();
        factory.close();
    }
}
