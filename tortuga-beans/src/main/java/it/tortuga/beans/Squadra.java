package it.tortuga.beans;

import java.util.Date;
import java.util.List;

public class Squadra extends GeneralBean {

	private String nomeSquadra;
	private Date dataCreazione;
	private List<String> listaPartecipanti;
	private IstitutoAllenamento istitutoAppartenenza;

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

	public List<String> getListaPartecipanti() {
		return listaPartecipanti;
	}

	public void setListaPartecipanti(List<String> listaPartecipanti) {
		this.listaPartecipanti = listaPartecipanti;
	}

}
