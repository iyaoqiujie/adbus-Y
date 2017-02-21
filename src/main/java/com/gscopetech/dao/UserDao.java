package com.gscopetech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gscopetech.entity.User;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/1/22
 */
public interface UserDao extends JpaRepository<User, Long> {
    @Modifying @Transactional
    @Query(value="UPDATE user SET  password=?,username=?  WHERE id = 1",nativeQuery=true)
    public void update(String password,String username);
}
