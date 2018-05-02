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
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> getAll(){
		
		return employeeMapper.selectByExampleWithDept(null);
	}



	/**
	 * Ա������
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	
	
	
}
