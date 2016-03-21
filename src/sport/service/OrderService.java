package sport.service;

import java.util.Date;
import java.util.List;

import sport.dao.OrderDao;
import sport.entity.Address;
import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.Shop;
import sport.entity.State;

public class OrderService {
	private OrderDao dao = new OrderDao();
	
	public List<OrderDetail> getOrderDetailByOid(int oid) {
		return dao.getOrderDetailByOid(oid);
	}
	
	public List<OrderForm> getAllOrderFormByUid(int uid) {
		return dao.getAllOrderFormByUid(uid);
	}
	
	public int getShopIdBygid(int gid) {
		return dao.getShopIdBygid(gid);
	}
	
	public List<Integer> getOidByUid(int uid) {
		return dao.getOidByUid(uid);
	}
	public State getStateBystateid(int stateid) {
		return dao.getStateBystateid(stateid);
	}
	public List<Integer> getGidByOid(int oid) {
		return dao.getGidByOid(oid);
	}
	public double getTotalByOid(int oid) {
		return dao.getTotalByOid(oid);
		
	}
	public int getSumByOid(int oid) {
		return dao.getSumByOid(oid);
	}
	
	public Date getDateByOid(int oid) {
		return dao.getDateByOid(oid);
	}
	
	public int getSateIdByOid(int oid) {
		return dao.getSateIdByOid(oid);
	}
	
	public int getAddressIdByOid(int oid) {
		return dao.getAddressIdByOid(oid);
	}
	public Address getAddressByaid(int aid) {
		return dao.getAddressByaid(aid);
	}
	
	public boolean createOrderForm(OrderForm orderForm,List<OrderDetail> orderDetails) {
		return dao.createOrderForm(orderForm,orderDetails);
	}
	
	public boolean createOrderForms(List<OrderForm> orderForms) {
		return dao.createOrderForms(orderForms);
	}
	
	public boolean createOrderDetail(List<OrderDetail> OrderDetails) {
		return dao.createOrderDetail(OrderDetails);
	}
}
