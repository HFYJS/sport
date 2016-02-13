package sport.entity;

import java.util.Date;

public class GoodsFavorites {
	private int g_ifd;
	private User user;
	private Goods goods;
	private Date date;

	public GoodsFavorites() {

	}

	public int getG_ifd() {
		return g_ifd;
	}

	public void setG_ifd(int g_ifd) {
		this.g_ifd = g_ifd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
