package org.tortuga.rest.api2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.tortuga.beans.ElementToUpdateBean;
import it.tortuga.beans.FilterGeneralBean;
import it.tortuga.beans.ListUsersBean;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

@Controller
@RequestMapping("spring")
public class SpringController {

	private DBAdminFeatures factory = new DBAdminFeatures();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User loginUser(@RequestBody User user) {
		return factory.loginUser(user);
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public User signUpUser(@RequestBody User user) {
		return factory.insertNewUser(user);
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public ElementToUpdateBean changePassword(@RequestBody ElementToUpdateBean beanChangeElement) {

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

	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	@ResponseBody
	public ListUsersBean userListByFilter(FilterGeneralBean generalFilter) {
		ListUsersBean beanToSend = new ListUsersBean();
		beanToSend.setUsers(factory.listUserByFilter(generalFilter));
		return beanToSend;
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	@ResponseBody
	public User getUserById(User user) {
		User userToSend = null;
		userToSend = factory.getUserById(user);
		return userToSend;
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("filename") MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			System.out.println("YEE");
		}
		return "";
	}

}
