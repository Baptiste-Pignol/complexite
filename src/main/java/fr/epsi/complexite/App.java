package fr.epsi.complexite;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class App {

    public static void main(String[] args) {

        Set<Individual> population = new HashSet<Individual>();

        for (int val = 0; val < 1000; val++) {
            population.add(new Individual(
                    Math.random() * 180,
                    Math.random() * 30 + 0.5,
                    Math.random() * 100 + 10,
                    Math.random() * 180,
                    Math.random() * 200 + 50,
                    Math.random() * 100 + 1,
                    Math.random() * 40 + 5
            ));
        }
        System.out.println("starting iteration");
        int count = 0;
        while (population.size() > 1) {
            System.out.println("\titeration: " + ++count);
            population = Utils.iterate(population);
            System.out.println(population);
        }
        System.out.println("ending iteration, final pop:" + population);
    }

}
