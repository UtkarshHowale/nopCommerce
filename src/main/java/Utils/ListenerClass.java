package Utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Driver.DriverManager;

public class ListenerClass extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			try {

				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));

				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

				String imgPath = new CommonFunctions().screenShot(DriverManager.getDriver(), result.getName());

				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
