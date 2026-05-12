package nomina.modelo;


public class Empleado {

    private String nombre;
    private String identificacion;
    private double salario;

    public Empleado() {
    }

    public Empleado(String nombre, String identificacion, double salario) {

        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if(identificacion == null || identificacion.trim().isEmpty()){
            throw new IllegalArgumentException("La identificación no puede estar vacía");
        }

        if(salario <= 0){
            throw new IllegalArgumentException("El salario debe ser mayor a 0");
        }

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.salario = salario;
    }

    public double getSalud() {
        return salario * 0.04;
    }

    public double getPension() {
        return salario * 0.04;
    }

    public double getSalarioNeto() {
        return salario - getSalud() - getPension();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}