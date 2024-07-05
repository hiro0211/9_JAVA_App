package jsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.ShowAllCustomerLogic;

public class ShowAllCustomerAction {
	public String execute(HttpServletRequest request) {
		String page = "";

		try {
			ShowAllCustomerLogic logic = new ShowAllCustomerLogic();
			ArrayList<Customer> Customer = logic.showAllCustomer();

			request.setAttribute("customer", Customer);

			page = "/ShowAllCustomerResultView.jsp";

		}catch (SalesBusinessException e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", e.getMessage());

			page = "/SalesErrorView.jsp";
		}

		return page;
	}
}
