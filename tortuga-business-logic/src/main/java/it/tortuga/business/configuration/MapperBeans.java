/**
 * 
 */
package it.tortuga.business.configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.document.bean.DocumentIstitutoAllenamentoDTO;
import it.tortuga.business.document.bean.DocumentSquadraDTO;
import it.tortuga.business.document.bean.DocumentUserDTO;

/**
 * @author pc ads
 *
 */
public class MapperBeans {
	private MapperBeans() {
	}

	// BEAN TO DOCUMENT

//	public static User documentUserToUser(DocumentUserDTO dto, DocumentSquadraDTO squadraDocument,
//			DocumentIstitutoAllenamentoDTO istitutoDocument, List<DocumentUserDTO> usersTeam) {
//		User user = new User();
//		Squadra squadra = new Squadra();
//		user.set_id(dto.get_id());
//		user.setCodiceFiscale(dto.getCodiceFiscale());
//		user.setCognome(dto.getCognome());
//		user.setDataNacita(new Date(dto.getDataNascita()));
//		user.setNome(dto.getNome());
//		user.setRuolo(dto.getRuolo());
//		user.setRuoloApplicativo(dto.getRuoloApplicativo());
//		if (squadraDocument != null) {
//			user.setSquadraAppartenenza(squadra);
//			squadra.set_id(squadraDocument.get_id());
//			squadra.setDataCreazione(new Date(squadraDocument.getDataCreazione()));
//			squadra.setListaPartecipanti(getUsersByDocuments(usersTeam, squadra));
//			squadra.setNomeSquadra(squadraDocument.getNomeSquadra());
//			if (istitutoDocument != null) {
//				squadra.setIstitutoAppartenenza(documentIstitutoToIstituto(istitutoDocument, squadra));
//			}
//		}
//		return user;
//	}
//
//	private static List<User> getUsersByDocuments(List<DocumentUserDTO> usersDocument, Squadra squadra) {
//		List<User> users = new ArrayList<User>();
//
//		for (DocumentUserDTO userDTO : usersDocument) {
//			User user = new User();
//			user.set_id(userDTO.get_id());
//			user.setCodiceFiscale(userDTO.getCodiceFiscale());
//			user.setCognome(userDTO.getCognome());
//			user.setDataNacita(new Date(userDTO.getDataNascita()));
//			user.setNome(userDTO.getNome());
//			user.setRuolo(userDTO.getRuolo());
//			user.setRuoloApplicativo(userDTO.getRuoloApplicativo());
//			user.setSquadraAppartenenza(squadra);
//			users.add(user);
//		}
//
//		return users;
//	}
//
//	public static Squadra documentTeamToTeam(DocumentSquadraDTO dto, DocumentIstitutoAllenamentoDTO dtoIstituto,
//			List<DocumentUserDTO> usersTeam) {
//		Squadra team = new Squadra();
//		if (usersTeam == null) {
//			usersTeam = new ArrayList<>();
//		}
//		team.set_id(dto.get_id());
//		team.setDataCreazione(new Date(dto.getDataCreazione()));
//		team.setIstitutoAppartenenza(documentIstitutoToIstituto(dtoIstituto, team));
//		team.setListaPartecipanti(getUsersByDocuments(usersTeam, team));
//		team.setNomeSquadra(dto.getNomeSquadra());
//		return team;
//
//	}
//
//	public static IstitutoAllenamento documentIstitutoToIstituto(DocumentIstitutoAllenamentoDTO dto,
//			Squadra teamIstituto) {
//		IstitutoAllenamento istituto = new IstitutoAllenamento();
//		istituto.set_id(dto.get_id());
//		istituto.setCitta(dto.getCitta());
//		istituto.setIndirizzo(dto.getIndirizzo());
//		istituto.setNomeIstituto(dto.getNomeIstituto());
//		istituto.setProvincia(dto.getProvincia());
//		istituto.setSquadraPresente(teamIstituto);
//
//		return istituto;
//	}
//
//	// DOCUMENT TO BEAN
//
//	public static DocumentIstitutoAllenamentoDTO istitutoToDocumentIstituto(IstitutoAllenamento istituto) {
//		DocumentIstitutoAllenamentoDTO istitutoDocument = new DocumentIstitutoAllenamentoDTO();
//		istitutoDocument.set_id(istituto.get_id());
//		istitutoDocument.setCitta(istituto.getCitta());
//		istitutoDocument.setId_squadraPresente(istituto.getSquadraPresente().get_id());
//		istitutoDocument.setIndirizzo(istituto.getIndirizzo());
//		istitutoDocument.setNomeIstituto(istituto.getNomeIstituto());
//		istitutoDocument.setProvincia(istituto.getProvincia());
//
//		return istitutoDocument;
//	}
//
//	public static DocumentUserDTO userToDocumentUser(User user) {
//		DocumentUserDTO dto = new DocumentUserDTO();
//
//		dto.set_id(user.get_id());
//		dto.setCodiceFiscale(user.getCodiceFiscale());
//		dto.setCognome(user.getCognome());
//		dto.setDataNascita(user.getDataNacita().getTime());
//		dto.setId_squadra(user.getSquadraAppartenenza().get_id());
//		dto.setNome(user.getNome());
//		dto.setPassword(TortugaUtility.getMD5Value(user.getPassword()));
//		dto.setRuolo(user.getRuolo());
//		dto.setRuoloApplicativo(user.getRuoloApplicativo());
//
//		return dto;
//	}
//
//	public static DocumentSquadraDTO teamToDocumentTeam(Squadra team) {
//		DocumentSquadraDTO dto = new DocumentSquadraDTO();
//		dto.set_id(team.get_id());
//		dto.setDataCreazione(team.getDataCreazione().getTime());
//		dto.setId_istitutoAppartenenza(team.getIstitutoAppartenenza().get_id());
//		dto.setNomeSquadra(team.getNomeSquadra());
//		List<String> idUsersToSave = new ArrayList<>();
//		for (User teamUser : team.getListaPartecipanti()) {
//			idUsersToSave.add(teamUser.get_id());
//		}
//		dto.setId_users(idUsersToSave);
//		return dto;
//	}

}
