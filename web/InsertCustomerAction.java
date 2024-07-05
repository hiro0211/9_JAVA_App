package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.InsertCustomerLogic;

public class InsertCustomerAction {
    public String execute(HttpServletRequest request) {
        String page = "InsertCustomerView.jsp";

        try {
            String customerCode = request.getParameter("CUSTOMER_CODE");
            String customerName = request.getParameter("CUSTOMER_NAME");
            String customerTelno = request.getParameter("CUSTOMER_TELNO");
            String customerPostalcode = request.getParameter("CUSTOMER_POSTALCODE");
            String customerAddress = request.getParameter("CUSTOMER_ADDRESS");
            int discountRate = Integer.parseInt(request.getParameter("DISCOUNT_RATE"));
            boolean deleteFlag = Boolean.parseBoolean(request.getParameter("DELETE_FLAG"));

            if (customerCode == null || customerCode.isEmpty() ||
                customerName == null || customerName.isEmpty() ||
                customerTelno == null || customerTelno.isEmpty() ||
                customerPostalcode == null || customerPostalcode.isEmpty() ||
                customerAddress == null || customerAddress.isEmpty()) {
                request.setAttribute("message", "すべてのフィールドを入力してください。");
                return page;
            }

            InsertCustomerLogic logic = new InsertCustomerLogic();
            Customer customer = new Customer(customerCode, customerName, customerTelno,
                                            customerPostalcode, customerAddress, discountRate,
                                            deleteFlag);
            customer = logic.insertCustomer(customer);

            request.setAttribute("customer", customer);
            request.setAttribute("message", "得意先情報が正常に登録されました。");
            page = "/InsertCustomerResultView.jsp";
        } catch (SalesBusinessException e) {
            request.setAttribute("message", e.getMessage());
        } catch (SalesSystemException e) {
            request.setAttribute("message", e.getMessage());
            page = "/SalesErrorView.jsp";
        } catch (NumberFormatException e) {
            request.setAttribute("message", "割引率は数値で入力してください。");
        }

        return page;
    }
}
