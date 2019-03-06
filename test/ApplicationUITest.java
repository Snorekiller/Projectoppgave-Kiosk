import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ApplicationUITest {

	@Test
	public void testQuit() {
		ApplicationUI appUI = new ApplicationUI();
		String input = "6";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		appUI.start();
	}
}