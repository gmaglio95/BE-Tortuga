package it.tortuga.beans;

import java.util.Date;
import java.util.List;

public class Squadra extends GeneralBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5344573975843017340L;
	private String nomeSquadra;
	private Date dataCreazione;
	private List<User> listaPartecipanti;
	private IstitutoAllenamento istitutoAppartenenza;
	private CalendarioMatch calendario;

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public IstitutoAllenamento getIstitutoAppartenenza() {
		return istitutoAppartenenza;
	}

	public void setIstitutoAppartenenza(IstitutoAllenamento istitutoAppartenenza) {
		this.istitutoAppartenenza = istitutoAppartenenza;
	}

	public CalendarioMatch getCalendario() {
		return calendario;
	}

	public void setCalendario(CalendarioMatch calendario) {
		this.calendario = calendario;
	}

	public List<User> getListaPartecipanti() {
		return listaPartecipanti;
	}

	public void setListaPartecipanti(List<User> listaPartecipanti) {
		this.listaPartecipanti = listaPartecipanti;
	}

}
