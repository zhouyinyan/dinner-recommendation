package com.zyy.app.dinner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DinnerApplicationTests {

    protected static final Logger logger = LoggerFactory.getLogger(DinnerApplicationTests.class);

	@Test
	public void contextLoads() {
        logger.info("应用启动正常....");
	}

}
