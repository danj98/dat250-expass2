package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int balance;
    private int limit;
    @OneToOne
    private Pincode pincode;
    @ManyToOne
    private Bank owningBank;

    public CreditCard() {

    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public void setPincode(Pincode pincode) { this.pincode = pincode; }
    public void setOwningBank(Bank owningBank) { this.owningBank = owningBank;}

    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public int getLimit() {
        return limit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }
}
