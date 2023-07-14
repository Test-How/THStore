package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssersionExample {
	 @Test
	    public void testAssertEquals() {
	        String expected = "Hello";
	        String actual = "Hello";
	        Assert.assertEquals(actual, expected);
	    }

	    @Test
	    public void testAssertNotEquals() {
	        int expected = 10;
	        int actual = 5;
	        Assert.assertNotEquals(actual, expected);
	    }

	    @Test
	    public void testAssertNull() {
	        String value = null;
	        Assert.assertNull(value);
	    }

	    @Test
	    public void testAssertNotNull() {
	        String value = "TestNG";
	        Assert.assertNotNull(value);
	    }

	    @Test
	    public void testAssertTrue() {
	        boolean condition = true;
	        Assert.assertTrue(condition);
	    }

	    @Test
	    public void testAssertFalse() {
	        boolean condition = false;
	        Assert.assertFalse(condition);
	    }

	    @Test
	    public void testAssertFail() {
	        Assert.fail("This test will always fail");
	    }
}
