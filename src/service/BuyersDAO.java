package service;

import java.util.List;
import entity.Buyers;

public interface BuyersDAO {

	//��ѯȫ���ͻ�
	public List<Buyers> queryAllBuyers();
	//ͨ���ͻ����sid��ѯ�ͻ�
	public Buyers queryBuyerByBid(String bid);
	//ͨ���ͻ�����sname��ѯ�ͻ�
	public Buyers queryBuyerByBname(String bname);
	//��ӿͻ�
	public boolean addBuyers(Buyers b);
	//�޸Ŀͻ�
	public boolean updateBuyers(Buyers b);
	//ɾ���ͻ�
	public boolean deleteBuyers(String bid);
	//ͨ���ͻ�����ģ�����ң�����������ʾ
	public List<Buyers> queryNameLike(String bname);
}
