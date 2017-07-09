package action;



import java.util.List;


import entity.Goods;

import service.GoodsDAO;
import service.impl.GoodsDAOImpl;



//��ƷAction��
public class GoodsAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//��ѯ���л�Ʒ
	public String query(){
		
		//��ҳ��ʾ��ÿҳ��������Ŀ
		int EachPageContentNum = 2;
		
		GoodsDAO sdao = new GoodsDAOImpl();
		int pageNow = 0;
		String pageLast = request.getParameter("g_pageLast");
		System.out.println(pageLast);
		if("0".equals(pageLast)){
			pageNow = Integer.parseInt(request.getParameter("g_pageNext"));
		}else{
			pageNow = Integer.parseInt(pageLast);
		}
		session.setAttribute("g_pageNow", pageNow);		
		if(pageNow>1){
			session.setAttribute("g_pageLast", pageNow-1);
		}else{
			session.removeAttribute("g_pageLast");
		}
		List<Goods> list = sdao.queryAllGoods((pageNow-1)*EachPageContentNum,EachPageContentNum+1);
		//�Ž�session��
		if(list!=null && list.size()>0){
			if(list.size()==EachPageContentNum+1){
				list.remove(EachPageContentNum);
				session.setAttribute("g_pageNext", pageNow+1);
			}else{
				session.setAttribute("g_pageNext",0);
			}
			session.setAttribute("goods_list", list);
		}
		return "query_success";
		
	}
	
	//ɾ����Ʒ�Ķ���
		public String delete(){
			GoodsDAO gdao = new GoodsDAOImpl();
			String gid = request.getParameter("gid");
			gdao.deleteGoods(gid);
			return "delete_success";
			
		}
		
		//ͨ��gid���һ�Ʒ
		public String findByGid(){
			GoodsDAO gdao = new GoodsDAOImpl();
			Goods g = gdao.queryGoodByGid(request.getParameter("gid"));
			if(g!=null){
				session.setAttribute("find_good",g);
				return "find_success";
			}else{
				return "find_fail";
			}
			
		}
		
		//ͨ�����Ʋ��һ�Ʒ
		public String findByGname(){
			GoodsDAO gdao = new GoodsDAOImpl();
			Goods g = gdao.queryGoodByGname(request.getParameter("gname"));
			if(g!=null){
				session.setAttribute("find_good",g);
				return "find_success";
			}else{
				return "find_fail";
			}
			
		}
		
		//��ӻ�Ʒ
		public String add() throws Exception{
			Goods g = new Goods();
			g.setGname(request.getParameter("gname"));
			g.setPrice(Integer.parseInt(request.getParameter("price")));
			g.setAmount(Integer.parseInt(request.getParameter("amount")));
			GoodsDAO gdao = new GoodsDAOImpl();
			gdao.addGoods(g);
			return "add_success";
		}
		
		
		//�޸Ļ�Ʒ����
		public String modify(){
			//��ô��ݹ�����ѧ�����
			String gid = request.getParameter("gid");
			GoodsDAO gdao = new GoodsDAOImpl();
			Goods s = gdao.queryGoodByGid(gid);
			//�����ڻỰ��
			session.setAttribute("modify_good", s);
			return "modify_success";
			
		}
		
		//�����޸ĺ��Ʒ�Ķ���
		public String save() throws Exception{
			Goods g = new Goods();
			g.setGid(request.getParameter("gid"));
			g.setGname(request.getParameter("gname"));
			g.setPrice(Integer.parseInt(request.getParameter("price")));
			g.setAmount(Integer.parseInt(request.getParameter("amount")));
			GoodsDAO gdao = new GoodsDAOImpl();
			gdao.updateGoods(g);
			return "save_success";
		}
		
		

		
		
}
