package zhou.test;

import zhou.db.DataProcess;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		//fail("Not yet implemented");
		System.out.println("hello");
		System.out.println(new DataProcess("AhaMall").CheckAdmin("admin", "123"));
	}

}
