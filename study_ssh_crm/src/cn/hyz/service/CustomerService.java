package cn.hyz.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.hyz.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
