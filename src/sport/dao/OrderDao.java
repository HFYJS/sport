package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.Shop;
import sport.entity.State;
import sport.service.GoodsService;
import sport.service.OrderService;
import sport.service.ShopService;
import sport.util.DBConnection;

public class OrderDao {
	
	public List<OrderForm> getAllOrderFormByUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<OrderForm> orderForms = new ArrayList<OrderForm>();
		String sql = "select * from order_form where uid=" + uid;
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OrderForm orderForm = new OrderForm();
				orderForm.setUser(new UserDao().getUserByUid(uid));
				orderForm.setOid(rs.getInt(1));
				orderForm.setState(new OrderService().getStateBystateid(rs.getInt(3)));;
				orderForm.setTotal(rs.getDouble(4));
				orderForm.setDate(rs.getDate(5));
				orderForm.setNote(rs.getString(6));
				
				orderForms.add(orderForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		
		return orderForms;
	}
	
	public List<OrderDetail> getOrderDetailByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		String sql = "select * from order_detail where oid=" + oid;
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setO_did(rs.getInt(1));
//				orderDetail.setOrderForm(new OrderService().getOrderFormByUid(uid));
				orderDetail.setGoods(new GoodsService().getGoodsByGid(rs.getInt(3)));
				orderDetail.setCount(rs.getInt(4));
				orderDetail.setSum(rs.getDouble(5));	
				
				orderDetails.add(orderDetail);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return orderDetails;
	}
	
	
	public State getStateBystateid(int stateid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		State state = null;
		String sql = "select * from state where stateid=" + stateid;
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				state = new State();
				state.setStateid(stateid);
				state.setName(rs.getString(2));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public int getShopIdBygid(int gid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;	
		Shop shop = null;
		String sql = "select * from goods where gid=" + gid;
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (Integer) null;
	}
	
	public List<Integer> getOidByUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Integer> oids = new ArrayList<Integer>();
		String sql = "select oid from order_form where uid=" + uid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int oid = rs.getInt(1);	
				oids.add(oid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		
		return oids;
	}
	
	public List<Integer> getGidByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Integer> gids = new ArrayList<Integer>();
		String sql = "select gid from order_detail where oid=" + oid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int gid = rs.getInt(1);	
				gids.add(gid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return gids;
	}
	
	public double getTotalByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;		
		String sql = "select total from order_form where oid=" + oid;
		double total = 0;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return total;
	}
	
	public int getSumByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;		
		String sql = "select sum(sum) from order_detail where oid=" + oid;
		int sum = 0;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return sum;
	}
	
	public Date getDateByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;		
		String sql = "select date from order_form where oid=" + oid;
		Date date = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				date = rs.getDate(1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return date;
	}
	
	public int getSateIdByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;		
		String sql = "select stateid from order_form where oid=" + oid;
		int stateid = 0;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				stateid = rs.getInt(1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return stateid;
	}
}
