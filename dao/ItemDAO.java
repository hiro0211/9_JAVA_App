/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * ItemDAO.java
 *
 */
package jsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jsys.sales.entity.Item;

public class ItemDAO {
	/** データベースの接続 */
	private Connection con;

	/**
	 * コンストラクタ
	 * @param con データベースの接続
	 */
	public ItemDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 商品を1件検索する。
	 * @param itemCode 商品コード
	 * @return 商品
	 * @throws SQLException
	 */
	public Item findItem(String itemCode) throws SQLException {
		String sql = "SELECT * FROM item WHERE item_code = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		Item item = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, itemCode);
			res =  stmt.executeQuery();

			// 検索結果がある場合、戻り値に設定する。
			if(res.next()) {
				item = new Item(
					res.getString("item_code"),
					res.getString("item_name"),
					res.getInt("price"),
					res.getInt("stock"));
			}else {
				System.out.println("!!!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}

		return item;
	}
}
