package service;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import entity.Order_out;
import entity.Orders;
import entity.Result_out;

public interface OrderoutDAO {

	    //��ѯ���н�������
		public List<Orders> queryAllOrderout(int beginIndex,int num);
		//ͨ�����������ܶ������в�ѯ����������������ͨ�ã�
		public Orders queryOrderByOoid(String ooid);
		//ͨ�����������Ų�ѯ��������
		public List<Order_out> queryOrderoutByOoid(String ooid);
		//��������ۻ�������Ŀ
		public boolean addOrder_outs(ActionContext context);
		//����ۻ�������Ŀ
		public boolean addOrder_out(Order_out oo);
		//���ܶ�����������ۻ�����
		public boolean addOrders(Orders order);
		//ɾ���ۻ�����
		public boolean deleteOrderouts(String ooid);
		
		//���������ۻ�����������Result_out����
		public List<Result_out> Result(String gname,String b_date,String e_date,String user,String customer,String note);
}
