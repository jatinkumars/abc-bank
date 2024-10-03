package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Bank {

    private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;
        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

    public String getFirstCustomer() {
        try {
            if (customers != null && !customers.isEmpty()) {
                return customers.get(0).getName();
            } else {
                return "No customers available";
            }
        } catch (IndexOutOfBoundsException e){
            logger.severe("Failed to retrieve the first customer: " + e.getMessage());
            return e.getMessage();
        }

        catch (Exception e){
            logger.severe("Failed to retrieve the first customer: " + e.getMessage());
            return e.getMessage();
        }
    }




}
