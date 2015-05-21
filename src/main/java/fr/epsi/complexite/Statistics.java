package fr.epsi.complexite;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Statistics {
    double[] data;
    double size;

    public Statistics(List<Individual> individuals) {
        this.data = new double[individuals.size()];
        for (int i = 0; i < individuals.size(); i++) {
            this.data[i] = individuals.get(i).evaluate();
        }
        size = data.length;
    }

    double getMean() {
        double sum = 0.0;
        for (double a : data)
            sum += a;
        return sum / size;
    }

    double getVariance() {
        double mean = getMean();
        double temp = 0;
        for (double a : data)
            temp += (mean - a) * (mean - a);
        return temp / size;
    }

    double getStdDev() {
        return Math.sqrt(getVariance());
    }

    public double median() {
        double[] b = new double[data.length];
        System.arraycopy(data, 0, b, 0, b.length);
        Arrays.sort(b);

        if (data.length % 2 == 0) {
            return (b[(b.length / 2) - 1] + b[b.length / 2]) / 2.0;
        } else {
            return b[b.length / 2];
        }
    }
}