package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class ITestListernerImpl implements ITestListener {

	
	@Override
	public void onFinish(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		//extentreportUtil.FlushReport();
		System.out.print("On finish from listener");
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		/*if(!isReportRunning) {			
			extentreportUtil.ExtentReport();
		    isReportRunning = true;				
		} */
		//features = BaseUtil.extent.createTest(Feature.class, "ericbank andriod sample");
		System.out.print("from on start");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		System.out.print("from on nTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		//TODO Auto-generated method stub
		System.out.print("from onTestFailure");
			
			try {
				//extentreportUtil.ExtentReportScreenShot();				
			//	BaseUtil.scenarioDef.fail("details").addScreenCaptureFromPath(extentreportUtil.ExtentReportScreenShot());				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	} 

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		System.out.print("from onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		System.out.print("from onTestSuccess");
	}

}