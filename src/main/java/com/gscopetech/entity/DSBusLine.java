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
@Table(name="ds_busline")
@Entity
@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class DSBusLine implements Serializable {
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "designsheet_id")
    @JsonBackReference
    private DesignSheet designSheet;

    // 线路
    private String line;
    // 級別
    private String level;
    // 车型
    private String type;
    // 数量
    private Integer count;
    // 刊期
    private Integer frequencyByDay;
    // 媒介核实意见
    private String comments;
    // 操作人
    private String operator;
    // 提交日期
    private Date subDate;
}
