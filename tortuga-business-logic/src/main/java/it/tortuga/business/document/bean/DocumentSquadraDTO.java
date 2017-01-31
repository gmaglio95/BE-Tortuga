package it.tortuga.business.document.bean;

import java.util.Date;
import java.util.List;

public class DocumentSquadraDTO {

	private String _id;
	private String nomeSquadra;
	private Date dataCreazione;
	private List<String> id_users;
	private String id_istitutoAppartenenza;

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

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<String> getId_users() {
		return id_users;
	}

	public void setId_users(List<String> id_users) {
		this.id_users = id_users;
	}

	public String getId_istitutoAppartenenza() {
		return id_istitutoAppartenenza;
	}

	public void setId_istitutoAppartenenza(String id_istitutoAppartenenza) {
		this.id_istitutoAppartenenza = id_istitutoAppartenenza;
	}

}
