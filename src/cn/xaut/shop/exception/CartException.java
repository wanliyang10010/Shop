package cn.xaut.shop.exception;

public class CartException extends Exception {

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
	 * 没有选中项目
	 */
	public static final int EMPTYITEM = 2;
	
	
	
	private int errFlag;
	private Object object;
	
	
	public CartException() {
		super();
	}
	
	/**
	 * 购物车异常
	 * @param errMsg 异常提示信息
	 * @param errFlag 错误标致
	 */
	public CartException(String errMsg,Integer errFlag) {
		super(errMsg);
		this.errFlag = errFlag;
	}
	

	// 为了传一些消息出去
	public CartException(String msg) {
		super(msg);
	}

	public CartException(String message, Throwable cause) {
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
