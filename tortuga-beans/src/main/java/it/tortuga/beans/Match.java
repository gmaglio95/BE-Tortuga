/**
 * 
 */
package it.tortuga.beans;

import java.util.Date;

/**
 * @author pc ads
 *
 */
public class Match extends GeneralBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id_squadraCasa;
	private String id_squadraOspite;
	private Date giornoPartita;
	private String orario;

	public String getId_squadraCasa() {
		return id_squadraCasa;
	}

	public void setId_squadraCasa(String id_squadraCasa) {
		this.id_squadraCasa = id_squadraCasa;
	}

	public String getId_squadraOspite() {
		return id_squadraOspite;
	}

	public void setId_squadraOspite(String id_squadraOspite) {
		this.id_squadraOspite = id_squadraOspite;
	}

	public Date getGiornoPartita() {
		return giornoPartita;
	}

	public void setGiornoPartita(Date giornoPartita) {
		this.giornoPartita = giornoPartita;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
