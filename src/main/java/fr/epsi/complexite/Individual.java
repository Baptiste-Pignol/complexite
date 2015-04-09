package fr.epsi.complexite;

/**
 * Created by Baptiste on 09/04/2015.
 * Represents an Individual, also called creature, or phenotype
 */
public class Individual implements Comparable<Individual> {

    public static final double GRAVITY = 9.81;
    /**
     * Genes
     */
    private double alphaAngle, armLength, legMass, strengthAngle, counterWeightMass, projectileMass, baseWidth;

    private double value;

    public Individual(double alphaAngle, double armLength, double legMass, double strengthAngle, double counterWeightMass, double projectileMass, double baseWidth) {
        this.alphaAngle = alphaAngle;
        this.armLength = armLength;
        this.legMass = legMass;
        this.strengthAngle = strengthAngle;
        this.counterWeightMass = counterWeightMass;
        this.projectileMass = projectileMass;
        this.baseWidth = baseWidth;

        this.value = this.getPortee();
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

    public int compareTo(Individual o) {
        if (this.value < o.value) {
            return -1;
        } else if (this.value > o.value) {
            return 1;
        } else {
            return 0;
        }
    }
}
