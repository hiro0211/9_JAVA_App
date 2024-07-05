/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * Item.java
 *
 */
package jsys.sales.entity;

import java.io.Serializable;

public class Item implements Serializable {
	/** 商品コード */
	private String itemCode;
	/** 商品名 */
	private String itemName;
	/** 単価 */
	private int price;
	/** 在庫数 */
	private int stock;

	/**
	 * コンストラクタ
	 */
	public Item() {}

	/**
	 * コンストラクタ
	 * @param itemCode 商品コード
	 * @param itemName 商品名
	 * @param price 単価
	 * @param stock 在庫数
	 */
	public Item(String itemCode, String itemName, int price, int stock) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}

	/**
	 * 商品コードを取得する。
	 * @return 商品コード
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * 商品コードを設定する。
	 * @param itemCode 商品コード
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * 商品名を取得する。
	 * @return 商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名を設定する。
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 単価を取得する。
	 * @return 単価
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 単価を設定する。
	 * @param price 単価
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 在庫数を取得する。
	 * @return 在庫数
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 在庫数を設定する。
	 * @param stock 在庫数
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

}
