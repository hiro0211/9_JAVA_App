package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.SearchCustomerLogic;

public class SearchCustomerAction {
	public String execute(HttpServletRequest request) {
		String page = "/SearchCustomerView.jsp";

		// クライアントの入力値を取得する。
		String customerCode = request.getParameter("CUSTOMER_CODE");
		// 未入力の場合、エラーメッセージをリクエストスコープに設定し、エラーページを返却する。
		if(customerCode != null && customerCode.equals("")) {
			request.setAttribute("message", "得意先コードが未入力です。");
			return page;
		}                                       

		try {
			// 商品検索用の業務Controllerを生成し、メソッドを呼び出す。
			SearchCustomerLogic logic = new SearchCustomerLogic();
			Customer customer= logic.searchCustomer(customerCode);

			// 検索結果をリクエストスコープに設定する。
			request.setAttribute("customer", customer);

			// 結果画面を戻り値に設定する。
			page = "/SearchCustomerResultView.jsp";
		} catch(SalesBusinessException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
		} catch(SalesSystemException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			// システムエラー画面を戻り値に設定する。
			page = "/SalesErrorView.jsp";
		}

		return page;
	}
}
