package cn.xaut.shop.service.impl;
import java.util.List;
import cn.xaut.shop.dao.DisputeFileDao;
import cn.xaut.shop.pojo.DisputeFile;
import cn.xaut.shop.service.DisputeFileService;
public class DisputeFileServiceImpl extends BaseServiceRImpl<DisputeFile,Integer> implements  DisputeFileService{

	private DisputeFileDao disputeFileDao = null;
	public void setDisputeFileDao(DisputeFileDao disputeFileDao) {
		this.disputeFileDao = disputeFileDao;
	}
	
	@Override
	public List<DisputeFile> getlist(Integer dsid) {
		 List<DisputeFile> accounts = disputeFileDao.findBydisId(dsid);
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts;
		   }
		   else
		   {
			  return  null;
		   }
	}

}
