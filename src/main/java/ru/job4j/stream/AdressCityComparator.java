package ru.job4j.stream;

import java.util.Comparator;

public class AdressCityComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        return a1.getCity().compareTo(a2.getCity());
    }
}