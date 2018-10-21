package cn.hyz.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.hyz.domain.Customer;

public interface CustomerDao {

	Integer getTotalCount(DetachedCriteria dc);

	List<Customer> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

}
