package service;

import java.util.List;
import entity.Sellers;

public interface SellersDAO {

	//��ѯȫ������
	public List<Sellers> queryAllSellers();
	//ͨ�����ұ��sid��ѯ����
	public Sellers querySellerBySid(String sid);
	//ͨ����������sname��ѯ����
	public Sellers querySellerBySname(String sname);
	//��ӳ���
	public boolean addSellers(Sellers s);
	//�޸ĳ���
	public boolean updateSellers(Sellers s);
	//ɾ������
	public boolean deleteSellers(String sid);
	//ͨ����������ģ�����ң�����������ʾ
	public List<Sellers> queryNameLike(String gname);
}
