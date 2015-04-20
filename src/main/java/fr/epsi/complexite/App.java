package fr.epsi.complexite;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class App {
    public static void main(String[] args) {

        Set<Individual> basicPopulation = new HashSet<Individual>();

        double sum = 0;

        for (Individual individual : basicPopulation) {
            sum += individual.evaluate();
        }

        double tmpVal = Math.random() * sum;
        double sum2 = 0;
        Individual individual1;
        selection(basicPopulation, tmpVal, sum2);

    }

    private static void selection(Set<Individual> basicPopulation, double tmpVal, double sum2) {
        Individual individual1;
        for (Individual individual : basicPopulation) {
            if (sum2 + individual.evaluate() > tmpVal) {
                individual1 = individual;
                break;
            } else {
                sum2 += individual.evaluate();
            }
        }
    }
}
