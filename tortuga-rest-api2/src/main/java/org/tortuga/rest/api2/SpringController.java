package org.tortuga.rest.api2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.tortuga.beans.ElementToUpdateBean;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

@Controller
@RequestMapping("spring")
public class SpringController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User loginUser(@RequestBody User user) {
		DBAdminFeatures factory = new DBAdminFeatures();
		return factory.loginUser(user);
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public User signUpUser(@RequestBody User user) {
		DBAdminFeatures factory = new DBAdminFeatures();
		return factory.insertNewUser(user);
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public ElementToUpdateBean changePassword(@RequestBody ElementToUpdateBean beanChangeElement) {
		DBAdminFeatures factory = new DBAdminFeatures();
		User userToSend = factory.loginUser(beanChangeElement.getUser());
		if (userToSend.getErrorDescriptors() == null) {
			beanChangeElement.getUser().setPassword(TortugaUtility.getMD5Value(beanChangeElement.getElementToUpdate()));
			userToSend = factory.changePasswordUser(beanChangeElement.getUser());
			beanChangeElement.setUser(userToSend);
		} else {
			beanChangeElement.setErrorDescriptors(userToSend.getErrorDescriptors());
		}
		return beanChangeElement;
	}

}
