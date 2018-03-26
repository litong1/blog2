package com.lt.blog.mapper;

import java.util.List;
import com.lt.blog.pojo.Account;
import com.lt.blog.util.Page;

public interface AccountMapper {

    /**
     * 添加账户
     * @param account
     */
    public void addAccount(Account account);
    /**
     * 删除账户
     * @param account
     */
    public void deleteAccount(Account account);
    /**
     * 更新账户信息
     * @param account
     */
    public void updateAccount(Account account);
    /**
     * 获取账户信息
     * @param id
     * @return
     */
    public Account getAccount(int id);
    
    /**
     * 判断用户名是否注册过
     * @param username
     * @return
     */
    public Account getAccountByUserName(String username);
    
//    /**
//     * 获取账户列表
//     * @return
//     */
//    public List<Account> list();
//    /**
//     * 获取分页形式账户列表
//     * @param page
//     * @return
//     */
//    public List<Account> listAll(Page page);
    
    /**
     * 获取用户总数  
     * @return
     */
    public int total(); 
}
