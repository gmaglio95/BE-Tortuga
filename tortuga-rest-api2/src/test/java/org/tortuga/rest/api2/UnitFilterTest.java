/**
 * 
 */
package org.tortuga.rest.api2;

import java.util.List;

import org.junit.Test;

import it.tortuga.beans.BeanType;
import it.tortuga.beans.FieldType;
import it.tortuga.beans.FilterGeneralBean;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

/**
 * @author pc ads
 *
 */
public class UnitFilterTest {

	@Test
	public void filterByType() {
		FilterGeneralBean bean = new FilterGeneralBean();

		bean.setField("88");
		bean.setType(BeanType.USER);
		bean.setFildToFilter(FieldType.TEAM);
		DBAdminFeatures factory = new DBAdminFeatures();

		List<User> users = factory.listUserByFilter(null);
		for (User us : users) {
			System.out.println(us.get_id());
		}
	}
}
