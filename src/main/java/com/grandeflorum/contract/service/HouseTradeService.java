package com.grandeflorum.contract.service;

import com.grandeflorum.common.domain.Page;
import com.grandeflorum.common.domain.ResponseBo;
import com.grandeflorum.common.service.IService;
import com.grandeflorum.contract.domain.ContractEdit;
import com.grandeflorum.contract.domain.HouseTrade;
import com.grandeflorum.project.domain.AuditParam;
import com.grandeflorum.project.domain.WFAudit;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public interface HouseTradeService extends IService<HouseTrade> {


    ResponseBo btachAuditHouseTrade(AuditParam auditParam);

    ResponseBo getHouseTradeHistory(String id);

     ResponseBo auditHouseTradeById(String id, int type) ;

    // 保存或更新商品房合同
    HouseTrade saveOrUpdateHouseTrade(HouseTrade houseTrade  );

    // 获取商品房合同
    ResponseBo getHouseTradeById(String id);

    //获取商品房合同列表
    ResponseBo getHouseTradeList(Page page);

    //获取商品房注销列表
    ResponseBo getHouseTradeCancelList(Page page);

    void printHt(String id ,HttpServletResponse response);

    //预览合同
    void previewHt(String id,HttpServletResponse response);

    ResponseBo linkH(String id,String hid);

    ResponseBo deleteHouseTradeByIds(List<String> ids);

    ResponseBo getHInfo(String hid);

    ResponseBo checkExistCompletionFile(String id);

    ResponseBo getEwmCheckInfo(String id,String type);

    ResponseBo sh(String id);

    File creatWord(String id, OutputStream os);

    ResponseBo AuditHouseTradeNew(WFAudit wfAudit);

}
