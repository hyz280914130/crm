package cn.hyz.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.hyz.dao.CustomerDao;
import cn.hyz.domain.Customer;
import cn.hyz.service.CustomerService;
import cn.hyz.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用dao查询总记录数
		Integer totalCount = customerDao.getTotalCount(dc);
		//创建PageBean对象
		PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
		//调用dao查询分页列表数据
		List<Customer> list = customerDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
