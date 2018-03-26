package com.lt.blog.service;

import java.util.List;

import com.lt.blog.pojo.Account;
import com.lt.blog.util.Page;

public interface AccountService {

    //	List<Account> list();
	int total();
	//List<Account> listAll(Page page);
	void add(Account c);
	void update(Account c);
	void delete(Account c);
	Account get(int id);
	
	Account getAccountByUserName(String username);
}
