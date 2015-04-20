package fr.epsi.complexite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baptiste on 09/04/2015.
 * Represents an Individual, also called creature, or phenotype
 */
public class Individual {

    public static final double GOAL = 300.;
    public static final double GRAVITY = 9.81;

    /**
     * Genes
     */
    private double alphaAngle, armLength, legMass, strengthAngle, counterWeightMass, projectileMass, baseWidth;

    private double value = -1;

    public Individual() {
    }

    public Individual(double alphaAngle, double armLength, double legMass, double strengthAngle, double counterWeightMass, double projectileMass, double baseWidth) {
        this.alphaAngle = alphaAngle;
        this.armLength = armLength;
        this.legMass = legMass;
        this.strengthAngle = strengthAngle;
        this.counterWeightMass = counterWeightMass;
        this.projectileMass = projectileMass;
        this.baseWidth = baseWidth;
        this.evaluate();
    }

    /**
     * Physical processing
     */

    private double getForceTraction() {
        return (this.counterWeightMass * GRAVITY) * Math.sin(this.strengthAngle) - (this.projectileMass * GRAVITY) * Math.cos(this.alphaAngle);
    }

    private double getMomentBras() {
        return this.getForceTraction() * this.armLength;
    }

    private double getMomentInertie() {
        return (this.legMass * Math.pow(this.armLength, 2)) / 3;
    }

    private double getAccelerationAngulaire() {
        return this.getMomentBras() / this.getMomentInertie();
    }

    private double getVelocite() {
        return getAccelerationAngulaire() * armLength;
    }

    private double getPortee() {
        return (Math.pow(this.getVelocite(), 2) / GRAVITY) * Math.sin(2 * (90 - this.alphaAngle));
    }

    public boolean isViable() {
        return Math.pow((Math.sin(this.alphaAngle) * armLength), 2) + Math.pow((Math.cos(this.alphaAngle) * armLength - baseWidth), 2)
                * Math.sin(alphaAngle) * (projectileMass * GRAVITY) <= (baseWidth * (counterWeightMass * GRAVITY));
    }

    private double getEnergie() {
        return (0.5) * projectileMass * Math.pow(getVelocite(), 2);
    }

    private double getTNTEnergie() {
        return (getEnergie() / 4184);
    }

    public double evaluate() {

        if (this.value == -1) {
            double res = 0.;
            if (isViable()) {
                res = 10000;
            }

            res -= Math.abs(GOAL - this.getPortee()) * 100;
            res += getTNTEnergie();
            this.value = res;
        }
        if (this.value < 0)
            this.value = 0;
        return this.value;
    }

    public List<Double> toList() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(alphaAngle);
        doubles.add(armLength);
        doubles.add(legMass);
        doubles.add(strengthAngle);
        doubles.add(counterWeightMass);
        doubles.add(projectileMass);
        doubles.add(baseWidth);
        return doubles;

    }

    public void fromList(List<Double> list) {
        alphaAngle = list.get(0);
        armLength = list.get(1);
        legMass = list.get(2);
        strengthAngle = list.get(3);
        counterWeightMass = list.get(4);
        projectileMass = list.get(5);
        baseWidth = list.get(6);
    }

    @Override
    public String toString() {
        return "Individual{" +
                "isViable=" + this.isViable() +
                ", portee=" + this.getPortee() +
                ", TNT=" + getTNTEnergie() +
                '}';
    }
}
