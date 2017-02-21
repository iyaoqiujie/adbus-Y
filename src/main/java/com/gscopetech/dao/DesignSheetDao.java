package com.gscopetech.dao;

import com.gscopetech.entity.DesignSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/17
 */
public interface DesignSheetDao extends JpaRepository<DesignSheet, Long> {
    List<DesignSheet> findByContractId(Long contractId);
}
