package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.AssignTPODao;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.AssignTPOService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignTPOServiceImpl implements AssignTPOService {
	@Autowired
	private AssignTPODao userDao;

	@Override
	public int assignTPO(UserDetailsBean userBean) {
		UserDetails user = new UserDetails();
		UserDetails checkUser = new UserDetails();
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
			return 0;
		}

		/*if (checkUser.getRoleId()==2|| checkUser.getRoleId()==4)*/ 
		if (checkUser.getRoleId().equalsIgnoreCase("5")) {
			return 55;
		}

		if (checkUser.getRoleId().equalsIgnoreCase("2")
				|| checkUser.getRoleId().equalsIgnoreCase("4")){
			System.out.println("Before update Faculty Role ID : " + checkUser.getRoleId() + "\n");
			//checkUser.setRoleId(5);
			checkUser.setRoleId("5");
			System.out.println("After update Faculty Role ID : " + checkUser.getRoleId() + "\n");
			userDao.assignTPO(checkUser);
			return 1;
		}

		else {
			System.out.println("Invalid Input : Faculty ");
			return 5;
		}
	}

	@Override
	public int assignTPCF(UserDetailsBean userBean) {
		UserDetails user = new UserDetails();
		UserDetails checkUser = new UserDetails();
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
			return 0;
		}

		/*if (checkUser.getRoleId()==2|| checkUser.getRoleId()==4)*/ 
		if (checkUser.getRoleId().equalsIgnoreCase("3")) {
			return 34;
		}
		else if (checkUser.getRoleId().equalsIgnoreCase("1")){
			System.out.println("Before update Student Role ID : " + checkUser.getRoleId() + "\n");
			//checkUser.setRoleId(5);
			checkUser.setRoleId("3");
			System.out.println("After update Student Role ID : " + checkUser.getRoleId() + "\n");
			userDao.assignTPO(checkUser);
			return 1;
		}
		else {
			System.out.println("Service :Invalid Input : Student");
			return 3;
		}
	}
	
	
	@Override
	public List<UserDetailsBean> viewUsers() {
		// TODO Auto-generated method stub
		List<UserDetails> userList = userDao.viewUsers();
		return convertToBean(userList);
	}

	public List<UserDetailsBean> convertToBean(List<UserDetails> userList) {
		List<UserDetailsBean> userBeanList = new ArrayList<UserDetailsBean>();
		for (UserDetails user : userList) {
			UserDetailsBean userBean = new UserDetailsBean();
			BeanUtils.copyProperties(user, userBean);
			userBeanList.add(userBean);
		}
		return userBeanList;
	}

	@Override
	public int removeTPO(UserDetailsBean userBean) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		UserDetails checkUser = new UserDetails();
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Service: Error : No User Defined" + "\n");
			return 0;
		}

		/*if (checkUser.getRoleId()==5) */
		if (checkUser.getRoleId().equalsIgnoreCase("5")) {
			System.out.println("Before update Faculty Role : " + checkUser.getRoleId() + "\n");
			//checkUser.setRoleId(2);
			checkUser.setRoleId("2");
			System.out.println("After update Faculty Role : " + checkUser.getRoleId() + "\n");
			userDao.removeTPO(checkUser);
			return 1;
		}
		else {
			System.out.println("Service: Error(LE): No Such User Exists");
			return 55;
		}
	}

	@Override
	public int removeTPCF(UserDetailsBean userBean) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		UserDetails checkUser = new UserDetails();
		BeanUtils.copyProperties(userBean, user);
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Service: Error : No User Defined" + "\n");
			return 0;
		}

		/*if (checkUser.getRoleId()==5) */
		if (checkUser.getRoleId().equalsIgnoreCase("3")) {
			System.out.println("Before update Faculty Role : " + checkUser.getRoleId() + "\n");
			//checkUser.setRoleId(2);
			checkUser.setRoleId("1");
			System.out.println("After update Faculty Role : " + checkUser.getRoleId() + "\n");
			userDao.removeTPO(checkUser);
			return 1;
		}
		else {
			System.out.println("Service: Error(LE): No Such User Exists");
			return 55;
		}
	
	}

}