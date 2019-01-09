package com.geo.geomantic;

import com.geo.geomantic.common.config.Global;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeomanticProjectApplicationTests {

	@Test
	public void contextLoads() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.out.println(Global.getProjectPath());
	}

}

