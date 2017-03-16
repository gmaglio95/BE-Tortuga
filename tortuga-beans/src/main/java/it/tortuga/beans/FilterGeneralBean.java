/**
 * 
 */
package it.tortuga.beans;

/**
 * @author pc ads
 *
 */
public class FilterGeneralBean extends GeneralBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6604350563708870348L;
	private BeanType type;
	private FieldType fildToFilter;
	private String field;

	public BeanType getType() {
		return type;
	}

	public void setType(BeanType type) {
		this.type = type;
	}

	public FieldType getFildToFilter() {
		return fildToFilter;
	}

	public void setFildToFilter(FieldType fildToFilter) {
		this.fildToFilter = fildToFilter;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
