package cn.xaut.shop.service.impl;
import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DisputeDao;
import cn.xaut.shop.pojo.Dispute;
import cn.xaut.shop.pojo.DisputeFile;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.service.DisputeFileService;
import cn.xaut.shop.service.DisputeService;
import cn.xaut.shop.service.MessageService;
import cn.xaut.shop.service.OrderSonService;

public class DisputeServiceImpl extends BaseServiceRImpl<Dispute,Integer> implements  DisputeService{
	private DisputeDao disputeDao = null;
	public void setDisputeDao(DisputeDao disputeDao) {
		this.disputeDao = disputeDao;
	}

	public Page<Dispute> getbetween(Page<Dispute> page,String start, String end, String state) {
		return  disputeDao.findByDate(page,start, end, state);
	}

	public Page<Dispute> getlist(Page<Dispute> page,String key, String stype) {
			  return   disputeDao.findByKey(page,key, stype);	   
	}

	@Override
	public Dispute getByOrder(Integer ordersonid) {
		  List<Dispute> accounts = disputeDao.findByOrder(ordersonid);	   
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public List<Dispute> getDisputelist(Integer userinfoId) {
		 List<Dispute> disputelist = disputeDao.findByUserId(userinfoId);	   
		   if(disputelist != null&&disputelist.size()>0)
		   {
			   return disputelist;
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public Page<Dispute> queryUncheck(Page<Dispute> page) {
		// TODO Auto-generated method stub
		return disputeDao.queryUncheck(page);
	}

	@Override
	public Page<Dispute> queryAll(Page<Dispute> page) {
		// TODO Auto-generated method stub
		return disputeDao.queryAll(page);
	}

	@Override
	public Dispute saveDispute(Dispute model, MessageService messageService,
			DisputeFileService disputeFileService, List<DisputeFile> list,
			OrderSonService orderSonService, OrderSon orderson) {
		// TODO Auto-generated method stub
		model=disputeDao.add(model);
		messageService.sendMessage(messageService,"新收到一条投诉信息需处理！", model.getUserInfo().getUserinfoId(), 0,
				"disputeFileAction_listfile.action", "disputeId", model.getDisputeid());
		messageService.sendMessage(messageService,"您的店铺被用户投诉,请点击查看详情！", model.getUserInfo().getUserinfoId(),model.getShop().getUserinfo().getUserinfoId(),
				"disputeAction_viewdispute.action", 
				"ordersonid", model.getOrder().getOrdersonId());
		if (list != null && list.size() > 0) {
			DisputeFile disputefile = new DisputeFile();
			for (int i = 0; i < list.size(); i++) {
				disputefile=list.get(i);
				disputefile.setDispute(model);
				disputeFileService.save(disputefile);
			}
		}
		orderson.setIsdispute("1");
		orderSonService.update(orderson);
		return model;
	}

	@Override
	public void updateDispute(Dispute dispute, MessageService messageService) {
		// TODO Auto-generated method stub
		disputeDao.update(dispute);
		messageService.sendMessage(messageService,"您的一条投诉信息已经处理，请查看！", dispute.getUserInfo().getUserinfoId(), 
				dispute.getUserInfo().getUserinfoId(),"disputeAction_viewdispute.action", 
				"ordersonid", dispute.getOrder().getOrdersonId());
		messageService.sendMessage(messageService,"一条与您店铺相关的用户投诉已被处理,请点击查看详情！",dispute.getUserInfo().getUserinfoId(), dispute.getShop().getUserinfo().getUserinfoId(),
				"disputeAction_viewdispute.action", "ordersonid", dispute.getOrder().getOrdersonId());
	}
}
