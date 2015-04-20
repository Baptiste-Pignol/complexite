package fr.epsi.complexite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fx on 20/04/2015.
 */
public class Utils {

    public static Individual crossing(Individual i1, Individual i2) {
        Individual res = new Individual();

        List<Double> firstList = i1.toList();
        List<Double> secondList = i2.toList();


        List<Double> finalList = new ArrayList<Double>();

        int mid = (int) (Math.random() * (firstList.size()-1));

        for (int i = 0; i < firstList.size(); i++) {
            if (i < mid) {
                finalList.add(firstList.get(i));
            } else {
                finalList.add(secondList.get(i));
            }
        }
        res.fromList(finalList);
        res.evaluate();
        return res;
    }

    public static Set<Individual> iterate(Set<Individual> basicPopulation) {
        Set<Individual> finalPopulation = new HashSet<Individual>();
        double sum = 0;

        for (Individual individual : basicPopulation) {
            sum += individual.evaluate();
        }
        for (int count = 0; count < basicPopulation.size() / 2; count++) {
            Individual[] selection = selection(basicPopulation, sum);

            Individual crossing = Utils.crossing(selection[0], selection[1]);
            finalPopulation.add(crossing);
        }
        return finalPopulation;
    }

    private static Individual[] selection(Set<Individual> basicPopulation, double sum) {
        double sum2 = 0;
        double tmpVal = Math.random() * sum;
        double tmpVal2 = Math.random() * sum;
        Individual individual1 = null;
        Individual individual2 = null;
        for (Individual individual : basicPopulation) {
            if (sum2 + individual.evaluate() >= tmpVal && individual1 == null) {
                individual1 = individual;
            }
            if (sum2 + individual.evaluate() >= tmpVal2 && individual2 == null) {
                individual2 = individual;
            }
            if (individual1 != null && individual2 != null) break;
            sum2 += individual.evaluate();
        }

        return new Individual[]{individual1, individual2};
    }

}
