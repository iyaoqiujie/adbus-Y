package com.gscopetech.service.impl;

import com.gscopetech.dao.DSBusLineDao;
import com.gscopetech.dao.DSMainDao;
import com.gscopetech.dao.DesignSheetDao;
import com.gscopetech.entity.DSBusLine;
import com.gscopetech.entity.DSMain;
import com.gscopetech.entity.DesignSheet;
import com.gscopetech.service.DSService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/17
 */
@Service
public class DSServiceImpl implements DSService{
    private static Logger myLogger = LoggerFactory.getLogger(DSServiceImpl.class);

    @Autowired
    private DesignSheetDao  dsDao;

    @Autowired
    private DSMainDao dsMainDao;

    @Autowired
    private DSBusLineDao dsBusLineDao;

    @Override
    public DSMain getDSheetMain(Long dsId) {
        DesignSheet myDS = dsDao.findOne(dsId);
        if(myDS == null) {
            return null;
        }
        return myDS.getDsMain();
    }

    @Override
    public List<DesignSheet> getAllSheets() {
        return dsDao.findAll();
    }

    @Override
    public DesignSheet getDSById(Long dsId) {
        return dsDao.findOne(dsId);
    }

    @Override
    public List<DesignSheet> getDSByContract(Long contractId) {
        return dsDao.findByContractId(contractId);
    }

    @Transactional
    @Override
    public DesignSheet createOneDSheet(Long contractId) {
        DesignSheet myDS = new DesignSheet();
        myDS.setContractId(contractId);
        myDS.setCreated(new Date());
        dsDao.save(myDS);
        return myDS;
    }

    @Transactional
    @Override
    public DSMain updateDSheetMain(DSMain dsMain) {
        Long myDSId = dsMain.getDesignSheet().getId();
        DesignSheet myDS = dsDao.findOne(myDSId);
        if(myDS == null) {
            myLogger.error("The given DesignSheet[id={}] does not exist", myDSId);
            return null;
        }
        DSMain myDSMain = myDS.getDsMain();
        if(myDSMain == null) {
            dsMain.setDesignSheet(myDS);
        } else {
            myLogger.info("Update DSMain[id={}]", myDSMain.getId());
            dsMain.setId(myDSMain.getId());
        }

        dsMain.setSubDate(new Date());
        dsMainDao.saveAndFlush(dsMain);
        return dsMain;
    }

    @Transactional
    @Override
    public List<DSBusLine> getDSheetBusLine(Long dsId){
        DesignSheet myDS = dsDao.findOne(dsId);
        if(myDS == null) {
            return null;
        }
        return myDS.getDsBusLineList();
    }

    @Transactional
    @Override
    public List<DSBusLine> batchInsertDSBusLine( List<DSBusLine> dsBusLineList) {
        if(dsBusLineList.size() == 0) {
            return null;
        }
        DesignSheet myDS = dsBusLineList.get(0).getDesignSheet();
        if(myDS == null) {
            myLogger.error("The specified design sheet is not created: ");
            return null;
        }
        for(DSBusLine myDSBusLine: dsBusLineList) {
            myDSBusLine.setSubDate(new Date());
            myDSBusLine.setDesignSheet(myDS);
            dsBusLineDao.save(myDSBusLine);
        }
        return myDS.getDsBusLineList();
    }

    @Transactional
    @Override
    public DSBusLine updateDSBusLine(DSBusLine dsBusLine){
        myLogger.warn("The given DSBusLine[id={}], operator={}", dsBusLine.getId(), dsBusLine.getOperator());
        dsBusLine.setSubDate(new Date());
        dsBusLineDao.save(dsBusLine);
        return dsBusLine;
    }

    @Transactional
    @Override
    public void  deleteDSBusLine(DSBusLine dsBusLine) {
        Long myId = dsBusLine.getId();
        if(dsBusLineDao.exists(myId)) {
            dsBusLineDao.delete(myId);
        } else {
            myLogger.warn("The specified DSBusLine[id={}] does NOT exist.", myId);
        }
    }

}
