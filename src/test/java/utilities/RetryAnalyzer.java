package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int retryCount = 0;

	int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {

			retryCount++;

			System.out.println("Retry test " + result.getName() + " " + retryCount + " time.");

			return true;
		}
		return false;
	}

}
