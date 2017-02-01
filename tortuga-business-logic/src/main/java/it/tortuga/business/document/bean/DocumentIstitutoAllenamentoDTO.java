package it.tortuga.business.document.bean;

public class DocumentIstitutoAllenamentoDTO {

	private String _id;
	private String nomeIstituto;
	private String citta;
	private String provincia;
	private String indirizzo;
	private String id_squadraPresente;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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

	public String getId_squadraPresente() {
		return id_squadraPresente;
	}

	public void setId_squadraPresente(String id_squadraPresente) {
		this.id_squadraPresente = id_squadraPresente;
	}

}
