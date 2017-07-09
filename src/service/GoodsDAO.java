package service;

import java.util.List;

import entity.Goods;

public interface GoodsDAO {

	//��ѯȫ����Ʒ
	public List<Goods> queryAllGoods(int beginIndex,int num );
	//ͨ����Ʒ���gid��ѯ��Ʒ
	public Goods queryGoodByGid(String gid);
	//ͨ����Ʒ����gname��ѯ��Ʒ
	public Goods queryGoodByGname(String gname);
	//��ӻ�Ʒ
	public boolean addGoods(Goods g);
	//�޸Ļ�Ʒ
	public boolean updateGoods(Goods g);
	//ɾ����Ʒ
	public boolean deleteGoods(String gid);
	//ͨ������ģ�����ң�����������ʾ
	public List<Goods> queryNameLike(String gname);
	//���ӿ��
	public boolean Goodsin(String gname , int num);
	//���ٿ��
	public boolean Goodsout(String gname , int num);
}
