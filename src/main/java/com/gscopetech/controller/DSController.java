package com.gscopetech.controller;

import com.gscopetech.entity.DSBusLine;
import com.gscopetech.entity.DSMain;
import com.gscopetech.entity.DesignSheet;
import com.gscopetech.service.DSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/17
 */
@RestController
@RequestMapping(value = "dsheet")
public class DSController {
    private static Logger myLogger = LoggerFactory.getLogger(DSController.class);

    @Autowired
    private DSService dsService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<DesignSheet> getAllSheets() {
        return dsService.getAllSheets();
    }

    @RequestMapping(value = "dsmain", method = RequestMethod.GET)
    @ResponseBody
    public DSMain getDSheetMain(@RequestParam(value = "dsId") Long dsId) {
        return dsService.getDSheetMain(dsId);
    }

    @RequestMapping(value = "dsbusline", method = RequestMethod.GET)
    @ResponseBody
    public List<DSBusLine> getDSheetBusLine(@RequestParam(value = "dsId") Long dsId) {
        return dsService.getDSheetBusLine(dsId);
    }

    @RequestMapping(value = "createDS", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DesignSheet createOneDSheet(@RequestParam(value="contractId")Long contractId) {
        return dsService.createOneDSheet(contractId);
    }

    @RequestMapping(value = "updateDSMain", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DSMain updateDSheetMain(@RequestBody DSMain dsMain) {
        return dsService.updateDSheetMain(dsMain);
    }

    @RequestMapping(value = "batchInsertDSBusLine", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<DSBusLine> batchInsertDSBusLine(@RequestBody List<DSBusLine> dsBusLineList) {
        return dsService.batchInsertDSBusLine(dsBusLineList);
    }

    @RequestMapping(value = "updateDSBusLine", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DSBusLine updateDSBusLine (@RequestBody DSBusLine dsBusLine) {
        return dsService.updateDSBusLine(dsBusLine);
    }

    @RequestMapping(value = "deleteDSBusLine", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteDSBusLine(@RequestBody DSBusLine dsBusLine) {
        dsService.deleteDSBusLine(dsBusLine);
    }
}
