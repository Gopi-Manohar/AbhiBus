package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import utils.AppUtils;

public class TakeScreenShot extends AppUtils
{
	public void screenShot() throws IOException
	{
		 Date currentdate = new Date();
		 String screenShotName = currentdate.toString().replace(" ", "-").replace(":", "-");
		 Screenshot failed = new AShot().takeScreenshot(driver);
		 ImageIO.write(failed.getImage(), "PNG", new File(".//screenshot//" + screenShotName +".png"));
		 
		 //File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(screenShotFile, new File(".//screenshot//" + screenShotName +".png"));
	}
}
