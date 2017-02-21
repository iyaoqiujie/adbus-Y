package com.gscopetech.service;

import com.gscopetech.entity.DSBusLine;
import com.gscopetech.entity.DSMain;
import com.gscopetech.entity.DesignSheet;

import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/17
 */
public interface DSService {
    List<DesignSheet> getAllSheets();



    DesignSheet createOneDSheet(Long contractId);
    DesignSheet getDSById(Long dsId);
    List<DesignSheet> getDSByContract(Long contractId);

    DSMain getDSheetMain(Long dsId);
    DSMain updateDSheetMain(DSMain dsMain);

    List<DSBusLine> getDSheetBusLine(Long dsId);
    List<DSBusLine> batchInsertDSBusLine(List<DSBusLine> dsBusLineList);
    DSBusLine updateDSBusLine(DSBusLine dsBusLine);
    void  deleteDSBusLine(DSBusLine dsBusLine);
}
