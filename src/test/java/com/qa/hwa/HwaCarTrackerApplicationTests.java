package com.qa.hwa;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class HwaCarTrackerApplicationTests {

	@Ignore //Test ignored because it causes conflict when running all the tests at the same time.
	//@Test
	void contextLoads() {
		HwaCarTrackerApplication.main(new String[] {});
	}

}
