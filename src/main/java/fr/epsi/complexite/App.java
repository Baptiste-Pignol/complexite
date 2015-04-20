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

    }

    private static Individual selection(Set<Individual> basicPopulation, double sum) {
        double sum2 = 0;
        double tmpVal = Math.random() * sum;
        Individual individual1 = null;
        for (Individual individual : basicPopulation) {
            if (sum2 + individual.evaluate() > tmpVal) {
                individual1 = individual;
                break;
            } else {
                sum2 += individual.evaluate();
            }
        }
        return individual1;
    }
}
