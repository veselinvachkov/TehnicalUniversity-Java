package TU_Java.week_6.first;

import TU_Java.week_6.first.Voter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ElectionSoftware {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Voter> voters = new ArrayList<>();
        voters.add(new Voter("Vesko", "Sofia", "Street1", "123"));
        voters.add(new Voter("Pepi", "Montana", "Street2", "276"));

        voters.removeIf(voter -> !voter.getCity().equals("Sofia"));

        voters.sort(Comparator
                .comparing(Voter::getStreet)
                .thenComparing(Voter::getAddress));

        for (Voter voter : voters) {
            System.out.println("Name: " + voter.getName() +
                    ", City: " + voter.getCity() +
                    ", street: " + voter.getStreet() +
                    ", Address: " + voter.getAddress());
        }
    }
}