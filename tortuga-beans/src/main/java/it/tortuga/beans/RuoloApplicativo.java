package it.tortuga.beans;

public enum RuoloApplicativo {

	AMMINISTRATORE("Amministratore"), PARTECIPANTE("Partecipante");

	private String ruolo;

	private RuoloApplicativo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

}
