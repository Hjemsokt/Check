package action;



import java.util.List;

import entity.Sellers;
import service.SellersDAO;
import service.impl.SellersDAOImpl;



//����Action��
public class SellersAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//��ѯ���г���
	public String query(){
		SellersDAO sdao = new SellersDAOImpl();
		List<Sellers> list = sdao.queryAllSellers();
		//�Ž�session��
		if(list!=null && list.size()>0){
			session.setAttribute("sellers_list", list);
			
		}
		return "sell_query_success";
		
	}
	
	//ɾ�����ҵĶ���
		public String delete(){
			SellersDAO sdao = new SellersDAOImpl();
			String sid = request.getParameter("sid");
			sdao.deleteSellers(sid);
			return "sell_delete_success";
			
		}
		
		//ͨ��sid���ҳ���
		public String findBySid(){
			SellersDAO sdao = new SellersDAOImpl();
			Sellers s = sdao.querySellerBySid(request.getParameter("sid"));
			if(s!=null){
				session.setAttribute("find_good",s);
				return "sell_find_success";
			}else{
				return "sell_find_fail";
			}
			
		}
		
		//ͨ�����Ʋ��һ�Ʒ
		public String findBySname(){
			SellersDAO sdao = new SellersDAOImpl();
			Sellers s = sdao.querySellerBySname(request.getParameter("sname"));
			if(s!=null){
				session.setAttribute("find_good",s);
				return "sell_find_success";
			}else{
				return "sell_find_fail";
			}
			
		}
		
		//��ӻ�Ʒ
		public String add() throws Exception{
			Sellers s = new Sellers();
			s.setSid(0);
			s.setSname(request.getParameter("sname"));
			s.setTel(request.getParameter("tel"));
			s.setAddress(request.getParameter("address"));
			SellersDAO sdao = new SellersDAOImpl();
			sdao.addSellers(s);
			return "sell_add_success";
		}
		
		
		//�޸Ļ�Ʒ����
		public String modify(){
			//��ô��ݹ�����ѧ�����
			String sid = request.getParameter("sid");
			SellersDAO sdao = new SellersDAOImpl();
			Sellers s = sdao.querySellerBySid(sid);
			//�����ڻỰ��
			session.setAttribute("modify_good", s);
			return "sell_modify_success";
			
		}
		
		//�����޸ĺ��Ʒ�Ķ���
		public String save() throws Exception{
			Sellers s = new Sellers();
			s.setSid(Integer.parseInt(request.getParameter("sid")));
			s.setSname(request.getParameter("sname"));
			s.setTel(request.getParameter("tel"));
			s.setAddress(request.getParameter("address"));
			SellersDAO sdao = new SellersDAOImpl();
			sdao.updateSellers(s);
			return "sell_save_success";
		}
		
		

		
		
}
