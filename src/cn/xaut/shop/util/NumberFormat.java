package cn.xaut.shop.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberFormat {
	
	/**
	 * 保留两位小数
	 * @return
	 */
	public static double Fix2(Double val)
	{
		DecimalFormat df=new DecimalFormat("0.00");  
	    return new Double(df.format(val).toString());
	}
	
	
	/**
	 * 保留两位小数
	 * @return
	 */
	public static float Fix2(float val)
	{
		DecimalFormat df=new DecimalFormat("0.00");  
	    return new Float(df.format(val).toString());
	}
	
	
	/*
	 * [参考:四舍五入]
	 *	BigDecimal b = new BigDecimal(ftotal);
     *	double total = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	 */
	
	/**
	 * double乘以double，保留精度
	 */
	public static double DoubleMultiDouble(Double a ,Double b)
	{
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		return  a1.multiply(b1).doubleValue();
	}

}
