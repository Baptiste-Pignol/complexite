package fr.epsi.complexite.bean;

/**
 * Created by fx on 20/04/2015.
 */
public class Parameter {

    private double alphaAngleMin, armLengthMin, legMassMin, strengthAngleMin, counterWeightMassMin, projectileMassMin, baseWidthMin;
    private double alphaAngleMax, armLengthMax, legMassMax, strengthAngleMax, counterWeightMassMax, projectileMassMax, baseWidthMax;
    private int individualCount;

    public Parameter() {
        alphaAngleMin = 0;
        alphaAngleMax = 180;

        armLengthMin = 0.5;
        armLengthMax = 30;

        legMassMin = 10;
        legMassMax = 100;

        strengthAngleMin = 0;
        strengthAngleMax = 180;

        counterWeightMassMin = 50;
        counterWeightMassMax = 200;

        projectileMassMin = 1;
        projectileMassMax = 100;

        baseWidthMin = 5;
        baseWidthMax = 40;

        individualCount = 1000;
    }

    public double getAlphaAngleMin() {
        return alphaAngleMin;
    }

    public void setAlphaAngleMin(double alphaAngleMin) {
        this.alphaAngleMin = alphaAngleMin;
    }

    public double getArmLengthMin() {
        return armLengthMin;
    }

    public void setArmLengthMin(double armLengthMin) {
        this.armLengthMin = armLengthMin;
    }

    public double getLegMassMin() {
        return legMassMin;
    }

    public void setLegMassMin(double legMassMin) {
        this.legMassMin = legMassMin;
    }

    public double getStrengthAngleMin() {
        return strengthAngleMin;
    }

    public void setStrengthAngleMin(double strengthAngleMin) {
        this.strengthAngleMin = strengthAngleMin;
    }

    public double getCounterWeightMassMin() {
        return counterWeightMassMin;
    }

    public void setCounterWeightMassMin(double counterWeightMassMin) {
        this.counterWeightMassMin = counterWeightMassMin;
    }

    public double getProjectileMassMin() {
        return projectileMassMin;
    }

    public void setProjectileMassMin(double projectileMassMin) {
        this.projectileMassMin = projectileMassMin;
    }

    public double getBaseWidthMin() {
        return baseWidthMin;
    }

    public void setBaseWidthMin(double baseWidthMin) {
        this.baseWidthMin = baseWidthMin;
    }

    public double getAlphaAngleMax() {
        return alphaAngleMax;
    }

    public void setAlphaAngleMax(double alphaAngleMax) {
        this.alphaAngleMax = alphaAngleMax;
    }

    public double getArmLengthMax() {
        return armLengthMax;
    }

    public void setArmLengthMax(double armLengthMax) {
        this.armLengthMax = armLengthMax;
    }

    public double getLegMassMax() {
        return legMassMax;
    }

    public void setLegMassMax(double legMassMax) {
        this.legMassMax = legMassMax;
    }

    public double getStrengthAngleMax() {
        return strengthAngleMax;
    }

    public void setStrengthAngleMax(double strengthAngleMax) {
        this.strengthAngleMax = strengthAngleMax;
    }

    public double getCounterWeightMassMax() {
        return counterWeightMassMax;
    }

    public void setCounterWeightMassMax(double counterWeightMassMax) {
        this.counterWeightMassMax = counterWeightMassMax;
    }

    public double getProjectileMassMax() {
        return projectileMassMax;
    }

    public void setProjectileMassMax(double projectileMassMax) {
        this.projectileMassMax = projectileMassMax;
    }

    public double getBaseWidthMax() {
        return baseWidthMax;
    }

    public void setBaseWidthMax(double baseWidthMax) {
        this.baseWidthMax = baseWidthMax;
    }

    public int getIndividualCount() {
        return individualCount;
    }

    public void setIndividualCount(int individualCount) {
        this.individualCount = individualCount;
    }
}

