package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class ShowAllCustomerLogic {
	public ArrayList<Customer> showAllCustomer()throws SalesBusinessException, SalesSystemException  {
		Connection con = null;
		ArrayList<Customer> list = null;

		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// 商品テーブルアクセス用のDAOを生成し、メソッドを呼び出す。
			CustomerDAO customerDAO = new CustomerDAO(con);
			 list = customerDAO.showAllCustomer();
			 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
		}	finally {
			try {
				if(con != null){
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
			}
		}

		return list;

	}
}
