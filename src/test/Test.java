package test;

public class Test {
	private int testNumber;
	private int testPassed = 0;
	
	public Test(int testNumber) {
		this.testNumber = testNumber;
	}
	
	public Test() {
		
	}
	
	public int getTestNumber() {
		return testNumber;
	}
	
	public void out(String name, boolean result, String message) {
		System.out.println("==============="+name.toUpperCase()+"===============");
		if (result==false) {
			System.out.println("Test failed: "+message);
		}
		else {
			System.out.println("Test passed: "+message);
			testPassed++;
			
		}
	}//out
	
	public void result() {
		System.out.println("===============RESULT===============");
		System.out.println("TOTAL TEST CASES: "+testNumber);
		System.out.println("TEST CASES PASSED: "+testPassed);
		System.out.println("PASS PERCENTAGE: "+((testPassed*100)/testNumber)+"%");
	}
	
	public void addTest( ) {
		testNumber++;
	}
}
