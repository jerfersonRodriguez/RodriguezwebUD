package nomina.negocio;

public class Nomina {

    public double calcular(double salario) {

        double descuento = salario * 0.08; // 8% ejemplo

        double resultado = salario - descuento;

        return resultado;
    }

}