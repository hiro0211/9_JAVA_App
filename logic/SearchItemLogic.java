/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * SearchItemController.java
 *
 */
package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.ItemDAO;
import jsys.sales.entity.Item;

public class SearchItemLogic {
	/**
	 * 商品を検索する。
	 * @param itemCode 商品コード
	 * @return 商品
	 * @throws SalesBusinessException データベースアクセスエラーが発生した場合
	 * @throws SalesSystemException システムエラーが発生した場合
	 */
	public Item searchItem(String itemCode) throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		Item item = null;

		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// 商品テーブルアクセス用のDAOを生成し、メソッドを呼び出す。
			ItemDAO itemDAO = new ItemDAO(con);
			item = itemDAO.findItem(itemCode);

			// 検索結果がない場合、エラーを発生させる。
			if(item == null) {
				throw new SalesBusinessException("該当する商品は存在しません。");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
		}finally {
			try {
				if(con != null){
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
			}
		}

		return item;
	}
}
