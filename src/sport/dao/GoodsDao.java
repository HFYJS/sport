package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sport.entity.Goods;
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

	// 修改商品
	public void modify(Goods goods) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		String sql = "update goods set actid=?,";
	}

}
