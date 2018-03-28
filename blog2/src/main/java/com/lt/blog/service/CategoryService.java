package com.lt.blog.service;

import java.util.List;

import com.lt.blog.pojo.Category;
import com.lt.blog.util.Page;

public interface CategoryService {

	/**
	 * 添加分类
	 * 
	 * @param category
	 */
	public int addCategory(Category category);

	/**
	 * 通过id删除分类
	 * 
	 * @param categoryid
	 */
	public void deleteCategory(Integer categoryid);

	/**
	 * 通过name删除分类
	 * @param categoryname
	 */
	public void deleteCategoryByName(String categoryname);
	/**
	 * 更新分类名称
	 * 
	 * @param category
	 */
	public void updateCategory(Category category);

	/**
	 * 获取分类列表
	 * @param userid
	 * @return
	 */
	public List<Category> listCategory(Integer userid);

	/**
	 * 获取分页形式分类列表
	 * 
	 * @param page
	 * @return
	 */
	public List<Category> listCategoryByPage(Page page,Integer userid);
	
	/**
	 * 获取分类总数
	 * 
	 * @return
	 */
	public int total(Integer userid);
}
