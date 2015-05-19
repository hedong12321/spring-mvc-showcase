package org.springframework.mystudy.service;


import java.util.List;

import org.springframework.mystudy.entity.User;
import org.springframework.mystudy.model.UserModel;

/**
 * 业务层
 */
public interface UserService {

	/**
	 * 添加
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 修改
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<User> findAllUserList();
	
	/**
	 * 根据条件查询数据
	 * @param user
	 * @return
	 */
	public List<User> findUserListByCondition(UserModel userModel);
	
	/**
	 * 通过条件查找用户
	 * @param userModel
	 * @return
	 */
	public User findUserByCondition(UserModel userModel);
	
	/**
	 * 通过ID查询User
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
}
