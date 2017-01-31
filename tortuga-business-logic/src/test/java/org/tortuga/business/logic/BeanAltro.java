package org.tortuga.business.logic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BeanAltro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7924840010997208622L;

	@Id
	private String _id;
	private String id_bean;
	private String name;

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getId_bean() {
		return id_bean;
	}

	public void setId_bean(String id_bean) {
		this.id_bean = id_bean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
