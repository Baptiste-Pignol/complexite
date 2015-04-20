package fr.epsi.complexite;

import fr.epsi.complexite.bean.Parameter;

/**
 * Created by fx on 20/04/2015.
 */
public class App {

    public static void main(String[] args) {
        Parameter myParameter = new Parameter();
        myParameter.setIndividualCount(100000);
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(myParameter);

        Individual tmp = geneticAlgorithm.yield();
        while (tmp != null) {
            System.out.println(tmp);
            tmp = geneticAlgorithm.yield();
        }

    }
}
