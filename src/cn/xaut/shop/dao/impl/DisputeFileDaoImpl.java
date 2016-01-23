package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.shop.dao.DisputeFileDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.DisputeFile;
public class DisputeFileDaoImpl extends HibernateRepository<DisputeFile,Integer>  implements
DisputeFileDao{
	public DisputeFileDaoImpl() {
		super();
	}
	public List<DisputeFile> findBydisId(Integer disId) {
		StringBuffer hqlBuff = new StringBuffer("FROM DisputeFile a WHERE a.dispute.disputeid=?");
		List<Object> values = new ArrayList<Object>();
		values.add(disId);
		return find(hqlBuff.toString(),values.toArray());
	}
}
