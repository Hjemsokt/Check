package service;

import java.util.List;

import entity.Users;

//�û�ҵ���߼��ӿ�
public interface UsersDAO {
	//�û���¼����
	public boolean usersLogin(Users u);
	//��ѯ���й���Ա
	public List<Users> queryAllusers();
	
	public void addUsers(Users u);
	public void deleteUsers(String uid);
	public Users queryUserByUid(String uid);
	public void updateUsers(Users u);
	
}
