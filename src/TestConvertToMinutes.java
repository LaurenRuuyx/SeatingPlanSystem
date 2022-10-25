import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConvertToMinutes {

	@Test
	void test() {
		MainLoop testConvertToMinutes = new MainLoop();
		int output1 = testConvertToMinutes.ConvertToMinutes("05:37");
		int output2 = testConvertToMinutes.ConvertToMinutes("09:21");
		assertEquals(337,output1);
		assertEquals(561,output2);
	}

}
