package com.hotMemo.web.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotMemo.web.crud.bean.Employee;
import com.hotMemo.web.crud.bean.Msg;
import com.hotMemo.web.crud.service.EmployeeService;

/**
 * ����Ա��CRUD����
 * 
 * @author li
 * 
 */

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// /**
	// * ��ѯԱ������(��ҳ��ѯ)
	// *
	// * @return
	// */
	// @RequestMapping("/emps")
	// public String getEmps(
	// @RequestParam(value = "pn", defaultValue = "1") Integer pn,
	// Model model) {
	// // �ⲻ��һ����ҳ��ѯ;
	// // ����PageHelper��ҳ���
	// // �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ�룬�Լ�ÿҳ�Ĵ�С
	// PageHelper.startPage(pn, 5);
	// // startPage��������ģ������ѯ����һ����ҳ��ѯ
	// List<Employee> emps = employeeService.getAll();
	// // ʹ��PageInfo��װ��ѯ��Ľ����ֻ��Ҫ��PageInfo����ҳ������ˡ�
	// // ��װ����ϸ�ķ�ҳ��Ϣ�����������ǲ�ѯ����������,���룬������ʾ��ҳ��
	// PageInfo page = new PageInfo(emps, 5);
	// model.addAttribute("pageInfo", page);
	// return "list";
	// }

	/**
	 * ����jackson����
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// �ⲻ��һ����ҳ��ѯ;
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������ģ������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		// ʹ��PageInfo��װ��ѯ��Ľ����ֻ��Ҫ��PageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ�����������ǲ�ѯ����������,���룬������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * Ա������
	 * 
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Employee employee){
		employeeService.saveEmp(employee);
		return Msg.success();
	}

}
