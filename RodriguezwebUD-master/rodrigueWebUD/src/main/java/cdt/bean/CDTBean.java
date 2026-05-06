package cdt.bean;

import cdt.modelo.CDT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named("cdt")
@RequestScoped
public class CDTBean {

    private CDT cdt = new CDT();

    public void calcular() {

        FacesContext context = FacesContext.getCurrentInstance();

       
        if (getInversion() <= 0) {
            context.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "La inversión debe ser mayor a 0", null));
            return;
        }

        if (getInteres() <= 0 || getInteres() > 100) {
            context.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "El interés debe estar entre 0 y 100", null));
            return;
        }

        

        if (getPlazo() <= 0) {
            context.addMessage("form:plazo",
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "El plazo debe ser mayor a 0", null));
            return;
        }

        if (getPlazo() < 30) {
            context.addMessage("form:plazo",
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Mínimo recomendado: 30 días", null));
        }

        
        cdt.calcular();
    }

    
    public double getInversion() { return cdt.getInversion(); }
    public void setInversion(double inversion) { cdt.setInversion(inversion); }

    public double getInteres() { return cdt.getInteres(); }
    public void setInteres(double interes) { cdt.setInteres(interes); }

    public int getPlazo() { return cdt.getPlazo(); }
    public void setPlazo(int plazo) { cdt.setPlazo(plazo); }

    public double getGanancia() { return cdt.getGanancia(); }
    public double getValorFuturo() { return cdt.getValorFuturo(); }
    public double getImpuesto() { return cdt.getImpuesto(); }
}