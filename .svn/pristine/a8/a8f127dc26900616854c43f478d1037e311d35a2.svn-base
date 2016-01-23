package cn.xaut.shop.exception;

public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 大于库存
	 */
	public static final int GREATER = 0;
	/**
	 * 失效或下架
	 */
	public static final int INVALID = 1;
	
	/**
	 * 大于单笔订单最大金额
	 */
	public static final int MAXMONEY = 2;
	
	
	private int errFlag;
	private Object object;
	
	
	public OrderException() {
		super();
	}

	// 为了传一些消息出去
	public OrderException(String msg) {
		super(msg);
	}
	
	public OrderException(String msg,int errFlag) {
		super(msg);
		this.errFlag = errFlag;
	}

	public OrderException(String message, Throwable cause) {
		super(message, cause);
	}

	public int getErrFlag() {
		return errFlag;
	}

	public void setErrFlag(int errFlag) {
		this.errFlag = errFlag;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
