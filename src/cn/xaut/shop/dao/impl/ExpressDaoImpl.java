package cn.xaut.shop.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ExpressDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Express;

public class ExpressDaoImpl extends HibernateRepository<Express, Integer>
		implements ExpressDao {
	
	public ExpressDaoImpl() {
		super();
	}

	public Page<Express> getViewList(Page<Express> page,String fromdate, String todate) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from Express as a where a.applyTime between  ? and  ? " +
				"  and a.state = '0' order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));

        Page<Express> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
	public Page<Express> getAlterList(Page<Express> page,int userid,String fromdate, String todate) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from Express as a where a.applyTime between  ? and  ? " +
				" and a.userinfo.userinfoId = ? and a.state = '0'  order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(userid);

        Page<Express> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
	public static String addOneday(String today){   
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd");   
        try   {   
            Date  d  =  new Date(f.parse(today).getTime()+24*3600*1000);     
              return  f.format(d);   
        }   
        catch(Exception ex) {   
            return   "输入格式错误";     
        }   
    }
}
