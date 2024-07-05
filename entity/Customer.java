package jsys.sales.entity;

import java.io.Serializable;

public class Customer implements Serializable {
	/** 得意先コード */
	private String customerCode;
	/** 得意先名 */
	private String customerName;
	/** 電話番号 */
	private String customerTelno;
	/** 郵便番号 */
	private String customerPostalcode;
	/** 住所 */
	private String customerAddress;
	/** 割引率 */
	private int discountRate;
	/** 削除フラグ */
	private boolean deleteFlag;

	/**
	 * コンストラクタ
	 */
	public Customer() {}

	/**
	 * コンストラクタ
	 * @param customerCode 得意先コード
	 * @param customerName 得意先名
	 * @param customerTelno 電話番号
	 * @param customerPostalcode 郵便番号
	 * @param customerAddress 住所
	 * @param discountRate 割引率
	 */
	public Customer(String customerCode, String customerName, String customerTelno, String customerPostalcode,
			String customerAddress, int discountRate, boolean deleteFlag) {
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.customerTelno = customerTelno;
		this.customerPostalcode = customerPostalcode;
		this.customerAddress = customerAddress;
		this.discountRate = discountRate;
		this.deleteFlag = deleteFlag;

	}

	/**
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode セットする customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName セットする customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return customerTelno
	 */
	public String getCustomerTelno() {
		return customerTelno;
	}

	/**
	 * @param customerTelno セットする customerTelno
	 */
	public void setCustomerTelno(String customerTelno) {
		this.customerTelno = customerTelno;
	}

	/**
	 * @return customerPostalcode
	 */
	public String getCustomerPostalcode() {
		return customerPostalcode;
	}

	/**
	 * @param customerPostalcode セットする customerPostalcode
	 */
	public void setCustomerPostalcode(String customerPostalcode) {
		this.customerPostalcode = customerPostalcode;
	}

	/**
	 * @return customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress セットする customerAddress
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * @return discountRate
	 */
	public int getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate セットする discountRate
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return deleteFlag
	 */
	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag セットする deleteFlag
	 */
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


}