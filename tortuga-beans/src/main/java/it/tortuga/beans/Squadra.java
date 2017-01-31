package it.tortuga.beans;

import java.util.Date;
import java.util.List;

public class Squadra extends GeneralBean{

	private String _id;
	private String nomeSquadra;
	private Date dataCreazione;
	private List<User> listaPartecipanti;
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

	public List<User> getListaPartecipanti() {
		return listaPartecipanti;
	}

	public void setListaPartecipanti(List<User> listaPartecipanti) {
		this.listaPartecipanti = listaPartecipanti;
	}

	public IstitutoAllenamento getIstitutoAppartenenza() {
		return istitutoAppartenenza;
	}

	public void setIstitutoAppartenenza(IstitutoAllenamento istitutoAppartenenza) {
		this.istitutoAppartenenza = istitutoAppartenenza;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
