/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * SearchItemAction.java
 *
 */
package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Item;
import jsys.sales.logic.SearchItemLogic;

public class SearchItemAction {
	/**
	 * 商品検索画面の検索ボタンが押された場合の処理を実行する。
	 * @param request リクエスト情報
	 * @return 次画面名
	 */
	public String execute(HttpServletRequest request) {
		String page = "/SearchItemView.jsp";

		// クライアントの入力値を取得する。
		String itemCode = request.getParameter("ITEM_CODE");
		// 未入力の場合、エラーメッセージをリクエストスコープに設定し、エラーページを返却する。
		if(itemCode != null && itemCode.equals("")) {
			request.setAttribute("message", "商品コードが未入力です。");
			return page;
		}

		try {
			// 商品検索用の業務Controllerを生成し、メソッドを呼び出す。
			SearchItemLogic logic = new SearchItemLogic();
			Item item = logic.searchItem(itemCode);

			// 検索結果をリクエストスコープに設定する。
			request.setAttribute("item", item);

			// 結果画面を戻り値に設定する。
			page = "/SearchItemResultView.jsp";
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
