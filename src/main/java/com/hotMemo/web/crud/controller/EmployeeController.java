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
 * 处理员工CRUD请求
 * 
 * @author li
 * 
 */

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// /**
	// * 查询员工数据(分页查询)
	// *
	// * @return
	// */
	// @RequestMapping("/emps")
	// public String getEmps(
	// @RequestParam(value = "pn", defaultValue = "1") Integer pn,
	// Model model) {
	// // 这不是一个分页查询;
	// // 引入PageHelper分页插件
	// // 在查询之前只需要调用,传入页码，以及每页的大小
	// PageHelper.startPage(pn, 5);
	// // startPage后面紧跟的，这个查询就是一个分页查询
	// List<Employee> emps = employeeService.getAll();
	// // 使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了。
	// // 封装了详细的分页信息，包括有我们查询出来的数据,传入，连续显示的页数
	// PageInfo page = new PageInfo(emps, 5);
	// model.addAttribute("pageInfo", page);
	// return "list";
	// }

	/**
	 * 导入jackson包，
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 这不是一个分页查询;
		// 引入PageHelper分页插件
		// 在查询之前只需要调用,传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的，这个查询就是一个分页查询
		List<Employee> emps = employeeService.getAll();
		// 使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了。
		// 封装了详细的分页信息，包括有我们查询出来的数据,传入，连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}

	/**
	 * 员工保存
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
