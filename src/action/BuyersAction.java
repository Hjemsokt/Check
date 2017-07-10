package action;



import java.util.List;

import entity.Buyers;
import service.BuyersDAO;
import service.impl.BuyersDAOImpl;



//�ͻ�Action��
public class BuyersAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//��ѯ���пͻ�
	public String query(){
		BuyersDAO bdao = new BuyersDAOImpl();
		List<Buyers> list = bdao.queryAllBuyers();
		//�Ž�session��
		if(list!=null && list.size()>0){
			session.setAttribute("buyers_list", list);
			
		}else{
			session.removeAttribute("buyers_list");
		}
		return "buy_query_success";
		
	}
	
	//ɾ�����ҵĶ���
		public String delete(){
			BuyersDAO bdao = new BuyersDAOImpl();
			String bid = request.getParameter("bid");
			bdao.deleteBuyers(bid);
			return "buy_delete_success";
			
		}
		
		//ͨ��bid���ҿͻ�
		public String findByBid(){
			BuyersDAO bdao = new BuyersDAOImpl();
			Buyers b = bdao.queryBuyerByBid(request.getParameter("bid"));
			if(b!=null){
				session.setAttribute("find_good",b);
				return "buy_find_success";
			}else{
				return "buy_find_fail";
			}
			
		}
		
		//ͨ�����Ʋ��һ�Ʒ
		public String findByBname(){
			BuyersDAO bdao = new BuyersDAOImpl();
			Buyers b = bdao.queryBuyerByBname(request.getParameter("bname"));
			if(b!=null){
				session.setAttribute("find_good",b);
				return "buy_find_success";
			}else{
				return "buy_find_fail";
			}
			
		}
		
		//��ӻ�Ʒ
		public String add() throws Exception{
			Buyers b = new Buyers();
			b.setBid(0);
			b.setBname(request.getParameter("bname"));
			b.setTel(request.getParameter("tel"));
			b.setAddress(request.getParameter("address"));
			BuyersDAO bdao = new BuyersDAOImpl();
			bdao.addBuyers(b);
			return "buy_add_success";
		}
		
		
		//�޸Ļ�Ʒ����
		public String modify(){
			//��ô��ݹ�����ѧ�����
			String bid = request.getParameter("bid");
			BuyersDAO bdao = new BuyersDAOImpl();
			Buyers b = bdao.queryBuyerByBid(bid);
			//�����ڻỰ��
			session.setAttribute("modify_good", b);
			return "buy_modify_success";
			
		}
		
		//�����޸ĺ��Ʒ�Ķ���
		public String save() throws Exception{
			Buyers b = new Buyers();
			b.setBid(Integer.parseInt(request.getParameter("bid")));
			b.setBname(request.getParameter("bname"));
			b.setTel(request.getParameter("tel"));
			b.setAddress(request.getParameter("address"));
			BuyersDAO bdao = new BuyersDAOImpl();
			bdao.updateBuyers(b);
			return "buy_save_success";
		}
		
		

		
		
}
