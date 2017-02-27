package org.tortuga.rest.api2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.tortuga.beans.ElementToUpdateBean;
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
	public User changePassword(@RequestBody ElementToUpdateBean beanChangePassword) {
		DBAdminFeatures factory = new DBAdminFeatures();
		User userToSend = factory.loginUser(beanChangePassword.getUser());
		if (userToSend.getErrorDescriptors() == null) {
			beanChangePassword.getUser().setPassword(beanChangePassword.getElementToUpdate());
			factory.changePasswordUser(beanChangePassword.getUser());
			userToSend = factory.changePasswordUser(beanChangePassword.getUser());
		}
		return userToSend;
	}

}
