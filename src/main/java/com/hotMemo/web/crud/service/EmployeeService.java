package com.hotMemo.web.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotMemo.web.crud.bean.Employee;
import com.hotMemo.web.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeMapper employeeMapper;
	
	
	
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll(){
		
		return employeeMapper.selectByExampleWithDept(null);
	}



	/**
	 * 员工保存
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	
	
	
}
