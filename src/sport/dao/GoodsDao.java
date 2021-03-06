package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Goods;
import sport.service.ActivityService;
import sport.service.CateService;
import sport.util.DBConnection;

public class GoodsDao {
	public GoodsDao() {

	}

	// 添加商品
	public void add(Goods goods) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		String sql = "insert into goods(sid,actid,catid,name,price,actprice,sales,amount,brand,popularity,imgpath,des)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, goods.getSid());
			pStat.setInt(2, goods.getActivity().getActid());
			pStat.setInt(3, goods.getCate().getCatid());
			pStat.setString(4, goods.getName());
			pStat.setDouble(5, goods.getPrice());
			pStat.setDouble(6, goods.getActPrice());
			pStat.setInt(7, goods.getSales());
			pStat.setInt(8, goods.getAmount());
			pStat.setString(9, goods.getBrand());
			pStat.setInt(10, goods.getPopularity());
			pStat.setString(11, goods.getImgPath());
			pStat.setString(12, goods.getDes());
			pStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != pStat) {
				try {
					pStat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
	}

	public Goods getGoodsByGid(int gid) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		Goods goods = null;
		String sql = "select * from goods where gid=?";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, gid);
			rs = pStat.executeQuery();
			if (rs.next()) {
				goods = new Goods();
				goods.setGid(gid);
				goods.setSid(rs.getInt(2));
				goods.setActivity(new ActivityService().getActivityByActid(rs
						.getInt(3)));
				goods.setCate(new CateService().getCateByCatid(rs.getInt(4)));
				goods.setName(rs.getString(5));
				goods.setPrice(rs.getDouble(6));
				goods.setActPrice(rs.getDouble(7));
				goods.setSales(rs.getInt(8));
				goods.setAmount(rs.getInt(9));
				goods.setBrand(rs.getString(10));
				goods.setPopularity(rs.getInt(11));
				goods.setImgPath(rs.getString(12));
				goods.setDes(rs.getString(13));
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
			if (null != pStat) {
				try {
					pStat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}

		return goods;
	}

	// 查询所有商品
	public List<Goods> getAll() {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Goods> goodses = new ArrayList<Goods>();
		String sql = "select * from goods order by gid";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGid(rs.getInt(1));
				goods.setSid(rs.getInt(2));

				goods.setActivity(new ActivityService().getActivityByActid(rs
						.getInt(3)));

				goods.setCate(new CateService().getCateByCatid(rs.getInt(4)));

				goods.setName(rs.getString(5));
				goods.setPrice(rs.getDouble(6));
				goods.setActPrice(rs.getDouble(7));
				goods.setSales(rs.getInt(8));
				goods.setAmount(rs.getInt(9));
				goods.setBrand(rs.getString(10));
				goods.setPopularity(rs.getInt(11));
				goods.setImgPath(rs.getString(12));
				goods.setDes(rs.getString(13));
				goodses.add(goods);
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
		return goodses;
	}

	public List<Goods> getAllGoodsesBySidOrderByPopularity(int sid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Goods> goodses = new ArrayList<Goods>();
		String sql = "select * from goods where sid=" + sid
				+ " order by popularity desc";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGid(rs.getInt(1));
				goods.setSid(rs.getInt(2));

				goods.setActivity(new ActivityService().getActivityByActid(rs
						.getInt(3)));

				goods.setCate(new CateService().getCateByCatid(rs.getInt(4)));

				goods.setName(rs.getString(5));
				goods.setPrice(rs.getDouble(6));
				goods.setActPrice(rs.getDouble(7));
				goods.setSales(rs.getInt(8));
				goods.setAmount(rs.getInt(9));
				goods.setBrand(rs.getString(10));
				goods.setPopularity(rs.getInt(11));
				goods.setImgPath(rs.getString(12));
				goods.setDes(rs.getString(13));
				goodses.add(goods);
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
		return goodses;
	}

	// 修改商品
	public void modify(Goods goods) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		String sql = "update goods set actid=?,catid=?,name=?,price=?,actprice=?,sales=?,amount=?,brand=?,popularity=?,imgpath=?,des=? where gid=?";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, goods.getActivity().getActid());
			pStat.setInt(2, goods.getCate().getCatid());
			pStat.setString(3, goods.getName());
			pStat.setDouble(4, goods.getPrice());
			pStat.setDouble(5, goods.getActPrice());
			pStat.setInt(6, goods.getSales());
			pStat.setInt(7, goods.getAmount());
			pStat.setString(8, goods.getBrand());
			pStat.setInt(9, goods.getPopularity());
			pStat.setString(10, goods.getImgPath());
			pStat.setString(11, goods.getDes());
			pStat.setInt(12, goods.getGid());
			pStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != pStat) {
				try {
					pStat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
	}

	public void remove(int gid) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		String sql = "delete from goods where gid=?";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, gid);
			pStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != pStat) {
				try {
					pStat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
	}

	public void remove(int[] gids) {
		for (int i : gids) {
			remove(i);
		}
	}

	public List<Goods> getPagedGoodses(int curPage, int pageSize) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Goods> goodses = null;
		String sql = "select gid from goods limit " + (curPage - 1) * pageSize
				+ "," + pageSize;

		try {
			goodses = new ArrayList<Goods>();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				goodses.add(getGoodsByGid(rs.getInt(1)));
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
		return goodses;
	}

	public int getCount() {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) from goods";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

	public List<Goods> getAllGoodsBySid(int sid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Goods> goodses = new ArrayList<Goods>();
		String sql = "select * from goods where sid=" + sid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGid(rs.getInt(1));
				goods.setSid(rs.getInt(2));

				goods.setActivity(new ActivityService().getActivityByActid(rs
						.getInt(3)));

				goods.setCate(new CateService().getCateByCatid(rs.getInt(4)));

				goods.setName(rs.getString(5));
				goods.setPrice(rs.getDouble(6));
				goods.setActPrice(rs.getDouble(7));
				goods.setSales(rs.getInt(8));
				goods.setAmount(rs.getInt(9));
				goods.setBrand(rs.getString(10));
				goods.setPopularity(rs.getInt(11));
				goods.setImgPath(rs.getString(12));
				goods.setDes(rs.getString(13));
				goodses.add(goods);
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
		return goodses;
	}

	public List<Goods> getAllGoodsesBySidOrderBySales(int sid) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Goods> goodses = new ArrayList<Goods>();
		String sql = "select * from goods where sid=" + sid
				+ " order by sales desc";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGid(rs.getInt(1));
				goods.setSid(rs.getInt(2));

				goods.setActivity(new ActivityService().getActivityByActid(rs
						.getInt(3)));

				goods.setCate(new CateService().getCateByCatid(rs.getInt(4)));

				goods.setName(rs.getString(5));
				goods.setPrice(rs.getDouble(6));
				goods.setActPrice(rs.getDouble(7));
				goods.setSales(rs.getInt(8));
				goods.setAmount(rs.getInt(9));
				goods.setBrand(rs.getString(10));
				goods.setPopularity(rs.getInt(11));
				goods.setImgPath(rs.getString(12));
				goods.setDes(rs.getString(13));
				goodses.add(goods);
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
		return goodses;
	}

}
