package com.gscopetech.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/17
 */
@Table(name="design_sheet")
@Entity
@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class DesignSheet implements Serializable {
    @GeneratedValue
    @Id
    private Long id;

    // 合同Id
    @Column(name="contract_id")
    private Long contractId;

    // 創建時間
    private Date created;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "designSheet")
    @JsonManagedReference
    private DSMain dsMain;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designSheet")
    private List<DSBusLine> dsBusLineList;
}
