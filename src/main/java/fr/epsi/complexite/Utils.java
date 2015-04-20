package fr.epsi.complexite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 20/04/2015.
 */
public class Utils {

    public static Individual crossing(Individual i1, Individual i2) {
        Individual res = new Individual();

        List<Double> firstList = i1.toList();
        List<Double> secondList = i2.toList();


        List<Double> finalList = new ArrayList<Double>();

        int mid = (int) Math.random() * (firstList.size());

        for (int i = 0; i < firstList.size(); i++) {
            if (i < mid) {
                finalList.add(firstList.get(i));
            } else {
                finalList.add(secondList.get(i));
            }
        }
        res.fromList(finalList);
        return res;
    }

}
