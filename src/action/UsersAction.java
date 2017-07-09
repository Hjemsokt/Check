package action;




import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;
import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	@SkipValidation
	//��ѯ���й���Ա
	public String query(){
		UsersDAO udao = new UsersDAOImpl();
		List<Users> list = udao.queryAllusers();
		//�Ž�session��
		if(list!=null && list.size()>0){
			session.setAttribute("users_list", list);
			
		}
		return "query_success";
		
	}

	@SkipValidation
	//��ӻ�Ʒ
	public String add() throws Exception{
		Users u = new Users();
		u.setUid(0);
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		UsersDAO udao = new UsersDAOImpl();
		udao.addUsers(u);
		return "add_success";
	}
	@SkipValidation
	//ɾ����Ʒ�Ķ���
	public String delete(){
		UsersDAO udao = new UsersDAOImpl();
		String uid = request.getParameter("uid");
		udao.deleteUsers(uid);
		return "delete_success";
		
	}
	@SkipValidation
	//�޸Ļ�Ʒ����
	public String modify(){
		//��ô��ݹ�����ѧ�����
		String uid = request.getParameter("uid");
		UsersDAO udao = new UsersDAOImpl();
		Users u = udao.queryUserByUid(uid);
		//�����ڻỰ��
		session.setAttribute("modify_good", u);
		return "modify_success";
		
	}
	@SkipValidation
	//�����޸ĺ��Ʒ�Ķ���
	public String save() throws Exception{
		Users u = new Users();
		u.setUid(Integer.parseInt(request.getParameter("uid")));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("passowrd"));
		UsersDAO udao = new UsersDAOImpl();
		udao.updateUsers(u);
		return "save_success";
	}
	
	//�û���¼����
	public String login(){
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(user)){
			//��session�б����¼�ɹ����û���
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	@SkipValidation
	//�û�ע������
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError","�û�������Ϊ�գ�");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError",	 "���볤�Ȳ�����6λ��");
		}
		
	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
