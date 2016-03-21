package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import sport.entity.Address;
import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.Shop;
import sport.entity.State;
import sport.entity.User;
import sport.service.GoodsService;
import sport.service.OrderService;
import sport.service.ShopService;
import sport.service.UserService;
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
				orderForm.setAddress(this.getAddressByaid(rs.getInt(2)));
				orderForm.setState(this.getStateBystateid(rs.getInt(4)));;
				orderForm.setTotal(rs.getDouble(5));
				orderForm.setDate(rs.getDate(6));
				orderForm.setNote(rs.getString(7));
				
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
	
	public Address getAddressByaid(int aid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		Address address = null;
		String sql = "select * from address where aid=" + aid;
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				address = new Address();
				address.setAid(aid);
				address.setUser(new UserDao().getUserByUid(rs.getInt(2)));	
				address.setAddress(rs.getString(3));
				address.setName(rs.getString(4));
				address.setTel(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
	
	public int getShopIdBygid(int gid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int sid = 0;
		String sql = "select sid from goods where gid=" + gid;
		
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				sid =  rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sid;
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
	
	public int getAddressIdByOid(int oid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;		
		String sql = "select aid from order_form where oid=" + oid;
		int aid = 0;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				aid = rs.getInt(1);	
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
		return aid;
	}
	
	public boolean createOrderForms(List<OrderForm> orderForms) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		boolean flag = false;
		String sql = "insert into order_form(aid,uid,stateid,total,date,note)" + "values(?,?,?,?,?,?)";
		
		for(OrderForm o : orderForms){			
			try {
				pStat = conn.prepareStatement(sql);
				pStat.setInt(1, o.getAddress().getAid());
				pStat.setInt(2, o.getAddress().getUser().getUid());
				pStat.setInt(3, o.getState().getStateid());
				pStat.setDouble(4, o.getTotal());
				pStat.setDate(5,  new java.sql.Date(0));
				pStat.setString(6, o.getNote());			 
				pStat.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (null != pStat) {
					try {
						pStat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		
		DBConnection.close(conn);
		return flag;
	}
	
	public boolean createOrderForm(OrderForm orderForm,List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		Statement stat = null;
		ResultSet rs = null;	
		boolean flag = false;
		int oid = 0;
		String sql1 = "insert into order_form(aid,uid,stateid,total,date,note)" + "values(?,?,?,?,?,?)";
		String sql3 = "select max(oid) from order_form";
		String sql2 = "insert into order_detail(oid,gid,count,sum)" + "values(?,?,?,?)";
			
			try {
				stat = conn.createStatement();
				pStat = conn.prepareStatement(sql1);
				pStat.setInt(1, orderForm.getAddress().getAid());
				pStat.setInt(2, orderForm.getAddress().getUser().getUid());
				pStat.setInt(3, orderForm.getState().getStateid());
				pStat.setDouble(4, orderForm.getTotal());
				pStat.setDate(5,  new java.sql.Date(0));
				pStat.setString(6, orderForm.getNote());			 
				pStat.executeUpdate();
				rs = stat.executeQuery(sql3);
				if (rs.next()) {
					oid = rs.getInt(1);	
				}
				for(OrderDetail o : orderDetails){
				pStat = conn.prepareStatement(sql2);
				pStat.setInt(1, oid);
				pStat.setInt(2, o.getGoods().getGid());
				pStat.setInt(3, o.getCount());
				pStat.setDouble(4, o.getSum());	
				pStat.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (null != pStat) {
					try {
						pStat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		
		
		DBConnection.close(conn);
		return flag;
	}
	
	public boolean createOrderDetail(List<OrderDetail> OrderDetails) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		boolean flag = false;
		String sql = "insert into order_detail(oid,gid,count,sum)" + "values(LAST_INSERT_ID(),?,?,?)";
		
		for(OrderDetail o : OrderDetails){			
			System.out.println(o.getOrderForm().getOid());
			System.out.println(o.getGoods().getGid());
			System.out.println(o.getGoods().getGid());
			System.out.println(o.getCount());
			try {
				pStat = conn.prepareStatement(sql);
//				pStat.setInt(1, o.getOrderForm().getOid());
				pStat.setInt(1, o.getGoods().getGid());
				pStat.setInt(2, o.getCount());
				pStat.setDouble(3, o.getSum());	
				pStat.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (null != pStat) {
					try {
						pStat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		
		DBConnection.close(conn);
		return flag;
	}
}
