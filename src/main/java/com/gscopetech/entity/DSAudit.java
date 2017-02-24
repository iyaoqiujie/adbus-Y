package com.gscopetech.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/24
 */
@Table(name="ds_audit")
@Entity
@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class DSAudit {
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "designsheet_id")
    @JsonBackReference
    private DesignSheet designSheet;

    // 部门
    private String department;
    // 审核员
    private String auditor;
    // 审批时间
    private Date auditTime;
    // 审批意见
    private String comments;
    // 审批动作
    private Boolean approved;
}
