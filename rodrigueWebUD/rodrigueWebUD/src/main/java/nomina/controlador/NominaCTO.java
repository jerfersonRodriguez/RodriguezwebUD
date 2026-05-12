package nomina.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import nomina.modelo.Persona;
import nomina.negocio.Nomina;

@Named("nominaCTO")
@SessionScoped
public class NominaCTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Persona persona = new Persona();
    private List<Persona> listaPersonas = new ArrayList<>();
    private Nomina nomina = new Nomina();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void calcularNomina() {

    	double salario = persona.getSalario();

    	double resultado = nomina.calcular(salario);

    	resultado = Math.round(resultado);

    	persona.setResultado(resultado);

    	double impuesto = salario - resultado;

    	persona.setImpuesto(impuesto);
    	
        FacesContext context = FacesContext.getCurrentInstance();

        // Validar identificación vacía
        if (persona.getIdentificacion() == null || persona.getIdentificacion().isEmpty()) {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La identificación es obligatoria"));
            return;
        }

        // Validar que solo tenga números
        if (!persona.getIdentificacion().matches("[0-9]+")) {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La identificación solo debe tener números"));
            return;
        }

        // Validar nombre
        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre es obligatorio"));
            return;
        }

        // Validar salario
        if (persona.getSalario() <= 0) {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un salario"));
            return;
        }

        // Validar identificación repetida
        for (Persona p : listaPersonas) {
            if (p.getIdentificacion().equals(persona.getIdentificacion())) {
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Esta identificación ya fue registrada"));
                return;
            }
        }

        // Calcular nómina
        double resultado1 = nomina.calcular(persona.getSalario());

        // Redondear resultado
        persona.setResultado(Math.round(resultado1));

        // Agregar a lista
        listaPersonas.add(persona);

        // Mensaje éxito
        context.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Empleado agregado correctamente"));

        // Limpiar formulario
        persona = new Persona();
    }
}