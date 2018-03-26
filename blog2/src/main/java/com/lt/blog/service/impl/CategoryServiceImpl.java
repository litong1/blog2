package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.CategoryMapper;
import com.lt.blog.pojo.Category;
import com.lt.blog.service.CategoryService;
import com.lt.blog.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper mapper;

	@Override
	public void addCategory(Category category) {
		mapper.addCategory(category);
	}

	@Override
	public void deleteCategory(Integer categoryid) {
		mapper.deleteCategory(categoryid);
	}

	@Override
	public void updateCategory(Category category) {
		mapper.updateCategory(category);
	}

	@Override
	public List<Category> listCategory(Integer userid) {
		return mapper.listCategory(userid);
	}

	@Override
	public List<Category> listCategoryByPage(Page page, Integer userid) {
		return mapper.listCategoryByPage(page, userid);
	}

	@Override
	public int total(Integer userid) {
		return mapper.total(userid);
	}

}
