package edu.luisguzman.reto5.reto5_2.process;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private List<BankAccount> accounts;

    public Customer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    // Getters, setters y métodos para manipular la lista de cuentas
}
