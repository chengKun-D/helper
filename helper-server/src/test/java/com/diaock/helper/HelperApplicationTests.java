package com.diaock.helper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diaock.helper.domain.User;
import com.diaock.helper.mapper.MenuMapper;
import com.diaock.helper.mapper.UserMapper;

@SpringBootTest
class HelperApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MenuMapper menuMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testMapper() {
		List<User> userList = userMapper.selectList(null);
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	void testMenuMapper() {
		List<String> list = menuMapper.selectPermsByUserId(1L);
		System.out.println(list);
	}

}
