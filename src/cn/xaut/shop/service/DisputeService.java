package cn.xaut.shop.service;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Dispute;
import cn.xaut.shop.pojo.DisputeFile;
import cn.xaut.shop.pojo.OrderSon;
public interface DisputeService extends BaseServiceR<Dispute,Integer>{
    public Page<Dispute> getbetween(Page<Dispute> page, String start,String end,String state);
    public Page<Dispute> getlist(Page<Dispute> page, String key,String stype);
	public Dispute getByOrder(Integer ordersonid);
/**
 * 
 * @param dsid
 * @return
 */
	public List<Dispute>  getDisputelist(Integer userinfoId);
public Page<Dispute> queryUncheck(Page<Dispute> page);
public Page<Dispute> queryAll(Page<Dispute> page);
public Dispute saveDispute(Dispute model, MessageService messageService,
		DisputeFileService disputeFileService, List<DisputeFile> list,
		OrderSonService orderSonService, OrderSon orderson);
public void updateDispute(Dispute dispute, MessageService messageService);
}
