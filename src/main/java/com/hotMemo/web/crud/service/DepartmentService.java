package com.hotMemo.web.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotMemo.web.crud.bean.Department;
import com.hotMemo.web.crud.dao.DepartmentMapper;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	
	public List<Department> getDepts(){
		
		List<Department> list=departmentMapper.selectByExample(null);
		return list;
	}
}
