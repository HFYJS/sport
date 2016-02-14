package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Activity;
import sport.entity.Cate;
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
		boolean flag = false;
		String sql = "insert into goods(sid,actid,catid,name,price,actprice,sales,amount,brand,popularity,imgpath,des)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, goods.getSid());
			pStat.setInt(2, goods.getActivity().getActid());
			pStat.setInt(3, goods.getCate().getCatid());
			pStat.setString(4, goods.getName());
			pStat.setDouble(5, goods.getPrice());
			pStat.setDouble(6, goods.getActprice());
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

				ActivityService activityService = new ActivityService();
				Activity activity = new Activity();
				activity.setActid(rs.getInt(3));
				activity.setName(activityService.getNameByActid(rs.getInt(3)));
				goods.setActivity(activity);

				CateService cateService = new CateService();
				Cate cate = new Cate();
				cate.setCatid(rs.getInt(4));
				cate.setName(cateService.getNameByCateid(rs.getInt(4)));
				goods.setCate(cate);

				goods.setName(rs.getString(5));
				goods.setPrice(rs.getDouble(6));
				goods.setActprice(rs.getDouble(7));
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
		String sql = "update goods set actid=?,";
	}

}