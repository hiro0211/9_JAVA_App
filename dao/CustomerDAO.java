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
import java.util.ArrayList;

import jsys.sales.entity.Customer;

public class CustomerDAO {
	/** データベースの接続 */
	private Connection con;

	/**
	 * コンストラクタ
	 * @param con データベースの接続
	 */
	public CustomerDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 商品を1件検索する。
	 * @param itemCode 商品コード
	 * @return 商品
	 * @throws SQLException
	 */
	public Customer findCustomer(String customerCode) throws SQLException {
		String sql = "SELECT * FROM customer WHERE customer_code = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		Customer customer = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customerCode);
			res =  stmt.executeQuery();

			// 検索結果がある場合、戻り値に設定する。
			if(res.next()) {
				customer = new Customer(
					res.getString("customer_code"),
					res.getString("customer_name"),
					res.getString("customer_telno"),
					res.getString("customer_postalcode"),
					res.getString("customer_address"),
					res.getInt("discount_rate"),
					res.getBoolean("delete_flag"));
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

		return customer;
	}

	public ArrayList<Customer> showAllCustomer() throws SQLException {
		String sql = "SELECT * FROM customer";
		ArrayList<Customer> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet res = null;
		Customer customer = null;

		try {
			stmt = con.prepareStatement(sql);
			res =  stmt.executeQuery();

			// 検索結果がある場合、戻り値に設定する。
			while(res.next()) {
				customer = new Customer(
					res.getString("customer_code"),
					res.getString("customer_name"),
					res.getString("customer_telno"),
					res.getString("customer_postalcode"),
					res.getString("customer_address"),
					res.getInt("discount_rate"),
					res.getBoolean("delete_flag"));
				list.add(customer);
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

		return list;
	}

	// 得意先情報を変更する処理
	public Customer updateCustomer(Customer customer) throws SQLException {
		String sql = "UPDATE customer SET customer_name= ?, customer_telno= ?,  "
				+ "customer_postalcode = ?, customer_address = ?, discount_rate = ?, "
				+ "delete_flag = ?  WHERE customer_code = ?";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getCustomerName());
			stmt.setString(2, customer.getCustomerTelno());
			stmt.setString(3, customer.getCustomerPostalcode());
			stmt.setString(4, customer.getCustomerAddress());
			stmt.setInt(5, customer.getDiscountRate());
			stmt.setBoolean(6, customer.isDeleteFlag());
			stmt.setString(7, customer.getCustomerCode());

			int customerRows = stmt.executeUpdate();
			if (customerRows == 0) {
				throw new SQLException("得意先の更新に失敗しました。該当するコードが見つかりません。");
			}
		} finally {
			// TODO: handle finally clause
			if (stmt !=null) {
				stmt.close();
			}
		}
		return customer;
	}

	// 得意先情報を削除する処理(delete_flagをtrueに変える)
	public Customer deleteCustomer(String customerCode) throws SQLException {
		String sql = "UPDATE customer SET delete_flag =true WHERE customer_code = ?";

		PreparedStatement stmt = null;
		Customer customer = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customerCode);
			 stmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			try {
				if (stmt !=null) {
					stmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return customer;
	}

	public Customer insertCustomer(Customer customer) throws SQLException {
	    String sql = "INSERT INTO customer (customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate, delete_flag) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    PreparedStatement stmt = null;

	    try {
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, customer.getCustomerCode());
	        stmt.setString(2, customer.getCustomerName());
	        stmt.setString(3, customer.getCustomerTelno());
	        stmt.setString(4, customer.getCustomerPostalcode());
	        stmt.setString(5, customer.getCustomerAddress());
	        stmt.setInt(6, customer.getDiscountRate());
	        stmt.setBoolean(7, customer.isDeleteFlag());

	        int affectedRows = stmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("得意先の登録に失敗しました。");
	        }
	    } finally {
	        if (stmt != null) {
	            stmt.close();
	        }
	    }
	    return customer;
	}
}
