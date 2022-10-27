package ru.otus;


import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    private final TreeMap<Customer, String> map = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> entry = map.firstEntry();
        return getNewEntry(entry);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> entry = map.higherEntry(customer);
        return getNewEntry(entry);

    }

    public void add(Customer customer, String data) {
        map.put(getNewCustomer(customer), data);
    }

    private Map.Entry<Customer, String> getNewEntry(Map.Entry<Customer, String> entry) {
        if (entry == null) {
            return null;
        }
        return new AbstractMap.SimpleEntry<>(getNewCustomer(entry.getKey()), entry.getValue());
    }

    private Customer getNewCustomer(Customer customer) {
        return new Customer(customer.getId(), customer.getName(), customer.getScores());
    }
}