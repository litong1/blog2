package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.AccountMapper;
import com.lt.blog.pojo.Account;
import com.lt.blog.service.AccountService;
import com.lt.blog.util.Page;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountMapper mapper ;
//    @Override
//    public List<Account> list() {
//
//	return mapper.list();
//    }

    @Override
    public int total() {
	
	return mapper.total();
    }

//    @Override
//    public List<Account> listAll(Page page) {
//	
//	return mapper.listAll(page);
//    }

    @Override
    public void add(Account c) {
	
	mapper.addAccount(c);
    }

    @Override
    public void update(Account c) {
	mapper.updateAccount(c);
    }

    @Override
    public void delete(Account c) {
	mapper.deleteAccount(c);
	
    }

    @Override
    public Account get(int id) {
	
	return mapper.getAccount(id);
    }

	@Override
	public Account getAccountByUserName(String username) {
		Account c = mapper.getAccountByUserName(username);
		
		return c;
	}

    
}
