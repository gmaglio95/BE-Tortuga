package it.tortuga.beans;

public class IstitutoAllenamento extends GeneralBean {

	private String nomeIstituto;
	private String citta;
	private String provincia;
	private String indirizzo;
	private String squadraPresente;

	public String getNomeIstituto() {
		return nomeIstituto;
	}

	public void setNomeIstituto(String nomeIstituto) {
		this.nomeIstituto = nomeIstituto;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getSquadraPresente() {
		return squadraPresente;
	}

	public void setSquadraPresente(String squadraPresente) {
		this.squadraPresente = squadraPresente;
	}


}
