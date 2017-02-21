package com.gscopetech.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/17
 */
@Table(name="ds_main")
@Entity
@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class DSMain  implements Serializable{
    @GeneratedValue
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "designsheet_id")
    @JsonBackReference
    private DesignSheet designSheet;

    // 合同编号
    private String contractCode;
    // 业务员
    private String salesMan;
    // 客户名称
    private String customer;
    // 营销中心
    private String company;
    // 广告内容
    private String adContent;
    // 车辆数量
    private Integer busNum;
    // 提交日期
    @Temporal(TemporalType.DATE)
    private Date subDate;
    // 报审画面数量
    private Integer auditPicCount;
    // 设计类型: 1-自主设计, 2-样稿套车
    private Integer designType;
    // 客户要求
    @Column(length = 1024)
    private String requirements;
}
