package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.UpdateCustomerLogic;

public class UpdateCustomerAction {
	public String execute(HttpServletRequest request) {
		String page ="UpdateCustomerView.jsp";

		// クライアントの入力値を取得する
		String customerCode = request.getParameter("CUSTOMER_CODE");
		String customerName = request.getParameter("CUSTOMER_NAME");
		String customerTelno = request.getParameter("CUSTOMER_TELNO");
		String customerPoStalcode = request.getParameter("CUSTOMER_POSTALCODE");
		String customerAddress = request.getParameter("CUSTOMER_ADDRESS");
        int discountRate = Integer.parseInt(request.getParameter("DISCOUNT_RATE"));
        boolean deleteFlag = Boolean.parseBoolean(request.getParameter("DELETE_FLAG"));


		try {
			UpdateCustomerLogic logic = new UpdateCustomerLogic();
			Customer customer = new Customer(customerCode, customerName, customerTelno,
																				customerPoStalcode, customerAddress, discountRate, 
																				deleteFlag);
			customer = logic.updateCustomer(customer);

			// 結果をリクエストスコープに設定する。
			request.setAttribute("customer", customer);

			page = "/UpdateCustomerResultView.jsp";

		} catch (SalesBusinessException e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
		} catch (SalesSystemException e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			// システムエラー画面を戻り値に設定する。
			page = "/SalesErrorView.jsp";
		}

		return page;

	}
}
