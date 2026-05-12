package nomina.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import nomina.modelo.Empleado;
import nomina.negocio.Nomina;
import java.io.Serializable;

@Named("empleadoBean")
@SessionScoped
public class EmpleadoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private Empleado empleado = new Empleado();
    private List<Empleado> lista = new ArrayList<>();

    public void agregarEmpleado(){

        FacesContext context = FacesContext.getCurrentInstance();

        if(empleado.getNombre()==null || empleado.getNombre().trim().isEmpty()){
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","El nombre no puede estar vacío"));
            return;
        }

        if(empleado.getIdentificacion()==null || empleado.getIdentificacion().trim().isEmpty()){
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","La identificación es obligatoria"));
            return;
        }

        if(!empleado.getIdentificacion().matches("[0-9]+")){
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","La identificación solo debe tener números"));
            return;
        }

        if(empleado.getSalario()<=0){
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","El salario debe ser mayor a 0"));
            return;
        }

        for(Empleado e: lista){
            if(e.getIdentificacion().equals(empleado.getIdentificacion())){
                context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Esta identificación ya existe"));
                return;
            }
        }

        lista.add(new Empleado(
                empleado.getNombre(),
                empleado.getIdentificacion(),
                empleado.getSalario()
        ));

        empleado = new Empleado();

        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Empleado agregado"));
    }

    public void eliminarEmpleado(Empleado e){
        lista.remove(e);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getLista() {
        return lista;
    }
}