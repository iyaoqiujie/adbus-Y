package com.gscopetech.service;

import com.gscopetech.entity.User;
import java.util.List;

/**
 * Created with adbus-Y.
 * Author  秋杰
 * Email   yaoqiujie@gscopetech.com
 * Date    2017/2/15
 */
public interface UserService {
    public void update(String password,String username);

    public List<User> getAllUsers();
}
