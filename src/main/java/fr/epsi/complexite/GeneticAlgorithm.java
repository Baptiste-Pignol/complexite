package fr.epsi.complexite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 20/04/2015.
 */
public class GeneticAlgorithm {

    private List<Individual> population;

    /**
     * Init
     */
    public GeneticAlgorithm() {

        population = new ArrayList<Individual>();

        for (int val = 0; val < 1000; val++) {
            // TODO Generify params
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
    }

    /**
     * Cross to Individual
     *
     * @param i1
     * @param i2
     * @return Child
     */
    private Individual crossing(Individual i1, Individual i2) {
        Individual res = new Individual();

        List<Double> firstList = i1.toList();
        List<Double> secondList = i2.toList();


        List<Double> finalList = new ArrayList<Double>();

        int mid = (int) (Math.random() * (firstList.size() - 1));

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

    /**
     * Iterate on generations
     *
     * @param basicPopulation
     * @return
     */
    public List<Individual> iterate(List<Individual> basicPopulation) {
        List<Individual> finalPopulation = new ArrayList<Individual>();
        double sum = 0;
        for (Individual individual : basicPopulation) {
            sum += individual.evaluate();
        }

        double max = 0;

        for (int count = 0; count < basicPopulation.size() / 2; count++) {
            Individual[] selection = selection(basicPopulation, sum);
            Individual crossing = this.crossing(selection[0], selection[1]);
            if (crossing.evaluate() > max) {
                max = crossing.evaluate();
                finalPopulation.add(0, crossing);
            } else {
                finalPopulation.add(crossing);
            }
        }
        return finalPopulation;
    }

    /**
     * Select two indivuduals
     *
     * @param basicPopulation Population
     * @param sum             Sum of eval
     * @return pair of individuals
     */
    private Individual[] selection(List<Individual> basicPopulation, double sum) {
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

    /**
     * Return the next best individual of generations
     * @return
     */
    public Individual yield() {
        population = this.iterate(population);
        return population.get(0);
    }
}
