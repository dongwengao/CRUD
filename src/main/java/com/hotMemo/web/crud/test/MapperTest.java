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
 * ����dao��Ĺ���
 * @author li
 *1.����SpringTestģ��
 *2.@ContextConfigurationָ��Spring�����ļ���λ��
 *3.ֱ��autowiredע��
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
	 * ����DepartmentMapper
	 */
	@Test
	public void testCRUD(){
//		//1.����SpringIOC����
//		ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//2.�������л�ȡmapper
//		DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
		
		//1.���뼸������
		
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null,"���Բ�"));
		
		//2.����Ա������,����Ա������
//		employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@hotMemo.com",1));
		
		//����������Ա����������ʹ�ÿ���ִ������������sqlSession
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