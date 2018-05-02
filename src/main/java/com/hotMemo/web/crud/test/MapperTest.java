package com.hotMemo.web.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotMemo.web.crud.bean.Employee;
import com.hotMemo.web.crud.dao.DepartmentMapper;
import com.hotMemo.web.crud.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author li
 *1.导入SpringTest模块
 *2.@ContextConfiguration指定Spring配置文件的位置
 *3.直接autowired注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
//		//1.创建SpringIOC容器
//		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//2.从容器中获取mapper
//		DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
		
		//1.插入几个部门
		
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));
		
		//2.生成员工数据,测试员工插入
//		employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@hotMemo.com",1));
		
		//批量插入多个员工；批量，使用可以执行批量操作的sqlSession
//		for(){
//			employeeMapper.insertSelective(new Employee(null,))
//		}
		
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uid=UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@hotMemo.com",1));
			
		}
		
	}
}
