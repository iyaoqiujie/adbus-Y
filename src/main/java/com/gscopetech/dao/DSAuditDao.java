package com.gscopetech.dao;

import com.gscopetech.entity.DSAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/24
 */
public interface DSAuditDao extends JpaRepository<DSAudit, Long>{
}
