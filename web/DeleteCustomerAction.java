package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.DeleteCustomerLogic;

public class DeleteCustomerAction {
	public String execute(HttpServletRequest request) {
		String page ="DeleteCustomerView.jsp";

		// クライアントの入力値を取得
		String customerCode = request.getParameter("CUSTOMER_CODE");

		if(customerCode != null && customerCode.equals("")) {
			request.setAttribute("message", "得意先コードが未入力です。");
			return page;
		}

        try {
            DeleteCustomerLogic logic = new DeleteCustomerLogic();
            Customer customer = logic.deleteCustomer(customerCode);

            //結果をリクエストスコープ
            request.setAttribute("customer", customer);

            page = "/DeleteCustomerResultView.jsp";

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
