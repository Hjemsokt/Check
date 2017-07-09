package service;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.Order_in;
import entity.Orders;
import entity.Result_in;

public interface OrderinDAO {

		
		//��ѯ���н�������
		public List<Orders> queryAllOrderin(int beginIndex,int num);
		//ͨ�����������ܶ������в�ѯ����������������ͨ�ã�
		public Orders queryOrderByOiid(String oiid);
		//ͨ�����������Ų�ѯ��������
		public List<Order_in> queryOrderinByOiid(String oiid);
		//������ӽ���������Ŀ
		public boolean addOrder_ins(ActionContext context);
		//��ӽ���������Ŀ
		public boolean addOrder_in(Order_in oi);
		//���ܶ���������ӽ�������
		public boolean addOrders(Orders order);
		//ɾ����������
		public boolean deleteOrderins(String oiid);
		
		//�������ҽ�������������Result_in����
		public List<Result_in> Result(String gname,String b_date,String e_date,String user,String customer,String note,int beginIndex,int num);
}
