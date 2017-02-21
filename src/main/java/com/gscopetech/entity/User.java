package com.gscopetech.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/15
 */
@Table(name="user")
@Entity
@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class User {
    @GeneratedValue
    @Id
    private Long id;
    private String username;
    private String password;
}
