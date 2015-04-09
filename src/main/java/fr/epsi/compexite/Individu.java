package fr.epsi.compexite;

/**
 * Created by Baptiste on 09/04/2015.
 */
public class Individu {
    private double angleAlpha, longueurBras, masseBras, angleForce, masseContrepoid, masseProjectile, longueurBase;

    public Individu(double angleAlpha, double longueurBras, double masseBras, double angleForce, double masseContrepoid, double masseProjectile, double longueurBase) {
        this.angleAlpha = angleAlpha;
        this.longueurBras = longueurBras;
        this.masseBras = masseBras;
        this.angleForce = angleForce;
        this.masseContrepoid = masseContrepoid;
        this.masseProjectile = masseProjectile;
        this.longueurBase = longueurBase;
    }

    public double getAngleAlpha() {
        return angleAlpha;
    }

    public void setAngleAlpha(double angleAlpha) {
        this.angleAlpha = angleAlpha;
    }

    public double getLongueurBras() {
        return longueurBras;
    }

    public void setLongueurBras(double longueurBras) {
        this.longueurBras = longueurBras;
    }

    public double getMasseBras() {
        return masseBras;
    }

    public void setMasseBras(double masseBras) {
        this.masseBras = masseBras;
    }

    public double getAngleForce() {
        return angleForce;
    }

    public void setAngleForce(double angleForce) {
        this.angleForce = angleForce;
    }

    public double getMasseContrepoid() {
        return masseContrepoid;
    }

    public void setMasseContrepoid(double masseContrepoid) {
        this.masseContrepoid = masseContrepoid;
    }

    public double getMasseProjectile() {
        return masseProjectile;
    }

    public void setMasseProjectile(double masseProjectile) {
        this.masseProjectile = masseProjectile;
    }

    public double getLongueurBase() {
        return longueurBase;
    }

    public void setLongueurBase(double longueurBase) {
        this.longueurBase = longueurBase;
    }

    public double getForceTraction() {
        return (this.masseContrepoid * 9.81) * Math.sin(this.angleForce) - (this.masseProjectile * 9.81) * Math.cos(this.angleAlpha);
    }

    public double getMomentBras() {
        return this.getForceTraction() * this.longueurBras;
    }

    public double getMomentInertie() {
        return (this.masseBras * Math.pow(this.longueurBras,2)) / 3;
    }

    public double getAccelerationAngulaire() {
        return this.getMomentBras() / this.getMomentInertie();
    }
}
