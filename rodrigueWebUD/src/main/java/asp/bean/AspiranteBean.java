package asp.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import asp.modelo.Aspirante;
import asp.modelo.AspiranteDAO;
import asp.modelo.ProgAcad;
import asp.modelo.ProgAcadDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("asp")
@RequestScoped
public class AspiranteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aspirante dto = new Aspirante();
	private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
	private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;

	public AspiranteBean() {
		ProgAcadDAO.cargaDatos();
	}

	public Aspirante getDto() {
		return dto;
	}

	public void setDto(Aspirante dto) {
		this.dto = dto;
	}

	public ArrayList<Aspirante> getListaAs() {
		return listaAs;
	}

	public void setListaAs(ArrayList<Aspirante> listaAs) {
		this.listaAs = listaAs;
	}

	public ArrayList<ProgAcad> getListaPa() {
		return listaPa;
	}

	public void setListaPa(ArrayList<ProgAcad> listaPa) {
		this.listaPa = listaPa;
	}

	public void registrar() {
		dto.setFecha_reg(LocalDate.now());
		if (dto.getPro_acad().getCod() >= 0 && dto.getPro_acad().getCod() < listaPa.size()) {
			dto.setPro_acad(listaPa.get(dto.getPro_acad().getCod()));
		} else {
			dto.setPro_acad(null);
		}
		listaAs.add(dto);
		System.out.println("Se registro: " + dto.toString());
	}

}



//Autor: Jerferson David Rodriguez Guarnizo