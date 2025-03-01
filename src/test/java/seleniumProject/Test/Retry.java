package seleniumProject.Test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int retry =0;
	int maxTry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retry<maxTry) {
			retry++;
			return true;
		}
		return false;
	}

}
