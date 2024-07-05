/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FrontController.java
 *
 */
package jsys.sales.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsys")
public class FrontController extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 * 										HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		String page = null;

		// 画面のボタンIDを取得する。
		request.setCharacterEncoding("UTF-8");
		String buttonID = request.getParameter("BUTTON_ID");

		// ボタンIDがnullの場合、デフォルト値を設定する。
		if (buttonID == null) {
			buttonID = "UC999_01";
		}

		// どのボタンが押されたかによって処理を振り分ける。
		switch(buttonID) {
			// メニュー画面の商品検索ボタンが押された場合
			// 商品検索結果画面の前画面に戻るボタンが押された場合
			case "UC000_01_01":
				page = "/SearchItemView.jsp";
				break;
			// 商品検索画面の検索ボタンが押された場合
			case "UC000_01_02":
				SearchItemAction action = new SearchItemAction();
				page = action.execute(request);
				break;
			// メニュー画面の得意先検索ボタンが押された場合
			case "UC000_02_01":
				page = "/SearchCustomerView.jsp";
				break;
			// メニューに戻るボタンが押された場合
			case "UC000_02_02":
				SearchCustomerAction action2 = new SearchCustomerAction();
				page = action2.execute(request);
				break;
			// メニューの得意先一覧ボタンが押された場合
			case "UC000_03_01":
				ShowAllCustomerAction action3 =new ShowAllCustomerAction();
				page = action3.execute(request);
				break;
			// 得意先更新ボタンが押された場合
			case "UC000_04_01":
				page = "/UpdateCustomerView.jsp";
				break;
			case "UC000_04_02":
				UpdateCustomerAction action4 = new UpdateCustomerAction();
				page = action4.execute(request);
				break;
			// 削除ボタンが押された場合
			case "UC000_05_01":
				page = "/DeleteCustomerView.jsp";
				break;
			case "UC000_05_02":
				DeleteCustomerAction action5 = new DeleteCustomerAction();
				page = action5.execute(request);
				break;
			case "UC000_06_01":
				page = "/InsertCustomerView.jsp";
				break;
			case  "UC000_06_02":
				InsertCustomerAction action6 = new InsertCustomerAction();
				page = action6.execute(request);
				break;
			case "UC999_01":
				page = "/Menu.html";
				break;
		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
