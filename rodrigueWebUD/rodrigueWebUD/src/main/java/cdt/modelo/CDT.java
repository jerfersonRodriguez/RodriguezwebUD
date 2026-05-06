package cdt.modelo;

public class CDT {

    private double inversion;
    private double interes;
    private int plazo;

    private double ganancia;
    private double valorFuturo;
    private double impuesto;

    public void calcular() {

        valorFuturo = inversion * Math.pow((1 + interes / 100), plazo / 365.0);

        ganancia = valorFuturo - inversion;

        impuesto = ganancia * 0.04;
    }

  
    public double getInversion() { return inversion; }
    public void setInversion(double inversion) { this.inversion = inversion; }

    public double getInteres() { return interes; }
    public void setInteres(double interes) { this.interes = interes; }

    public int getPlazo() { return plazo; }
    public void setPlazo(int plazo) { this.plazo = plazo; }

    public double getGanancia() { return ganancia; }
    public double getValorFuturo() { return valorFuturo; }
    public double getImpuesto() { return impuesto; }
}