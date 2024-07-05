package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class UpdateCustomerLogic {

	public Customer updateCustomer(Customer customer) throws SalesBusinessException, SalesSystemException {
		Connection con = null;
//		Customer customer = null;
//		Boolean result =false;

		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// 得意先テーブルにアクセスしメソッドを呼び出す。
			CustomerDAO customerDAO = new CustomerDAO(con);
			customer=	customerDAO.updateCustomer(customer);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
		} finally {
			try {
				if(con != null){
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
				throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
			}
		}

		return customer;

	}
}
