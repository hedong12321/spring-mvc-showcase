package org.springframework.mystudy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.mystudy.dao.BaseDAO;
import org.springframework.mystudy.entity.User;
import org.springframework.mystudy.model.UserModel;
import org.springframework.mystudy.service.UserService;
import org.springframework.mystudy.utils.Util;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDAO<User> userDao;
	
	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> findAllUserList() {

		return userDao.find("from User u order by u.createTime desc");
	}

	@Override
	public List<User> findUserListByCondition(UserModel userModel) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		
		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		return userDao.find(hql.toString(), paramList);
	}

	@Override
	public User findUserByCondition(UserModel userModel) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		
		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		if (paramList.size() == 0) {
			return null;
		}
		return userDao.get(hql.toString(), paramList.toArray());
	}

	@Override
	public User getUserById(int id) {
		return userDao.get(User.class, id);
	}

}
