package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AppUtils;


public class LaunchPage extends AppUtils
{
	@FindBy(id="source")
	WebElement source;
	
	@FindBy(id="destination")
	WebElement to;
	//comments
	@FindBy(id="ui-id-1")
	WebElement sourcelist;
	
	@FindBy(id="ui-id-2")
	WebElement destinationlist;
	
	@FindBy(id="datepicker1")
	WebElement fromDate;
	
	@FindBy(xpath="//input[@id='datepicker2']")
	WebElement toDate;
	
	@FindBy(xpath="//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']")
	List<WebElement> month;
	
	@FindBy(xpath="//div[@class='ui-datepicker-group ui-datepicker-group-first']//tr//td")
	List<WebElement> date;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	WebElement next;
		
	@FindBy(xpath="//a[@tabindex='5']")
	WebElement searchlist;
	
	
	public LaunchPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void searchList(String src, String dstn)
	{
		source.click();
		source.sendKeys(src);
		
		List<WebElement> srclist=sourcelist.findElements(By.tagName("li"));
		for (int i = 0; i <srclist.size(); i++)
		{
			System.out.println(srclist.get(i).getText());
			if (src.equals(srclist.get(i).getText()))
			{
				srclist.get(i).click();
			}
		}
	
		to.click();
		to.sendKeys(dstn);
		List<WebElement> dstnlist=destinationlist.findElements(By.tagName("li"));
		for (int j = 0; j < dstnlist.size(); j++)
		{
			System.out.println(dstnlist.get(j).getText());
			if (dstn.equals(dstnlist.get(j).getText()))
			{
				dstnlist.get(j).click();
			}
		}	
	}
	public void selectFromDate(String fromMonth, String selectfromdate) throws InterruptedException
	{
		fromDate.click();
		Thread.sleep(5000);
		while (!fromMonth.equals(month))
		{
			next.click();
			break;
		}
		for (int i = 1; i < date.size(); i++) 
		{
			if (selectfromdate.equals(date.get(i).getText()))
			{
				date.get(i).click();
			}
		}		
	}
	public void selectToDate(String toMonth, String selecttodate) throws InterruptedException
	{
		toDate.click();
		Thread.sleep(5000);
		while (!toMonth.equals(month))
		{
			next.click();
			break;
		}
		for (int i = 1; i < date.size(); i++) 
		{
			if (selecttodate.equals(date))
			{
				date.get(i).click();
			}
		}
		
	}
	public boolean search()
	{
		searchlist.click();
		String title = driver.getTitle();
		if (title.contains("bus_search")) 
		{
			return true;
		}else
			return false;
	}
	
	public void searchListWithInvalidData(String src, String dstn)
	{
		source.click();
		source.sendKeys(src);
		
		List<WebElement> srclist=sourcelist.findElements(By.tagName("li"));
		for (int i = 0; i <srclist.size(); i++)
		{
			System.out.println(srclist.get(i).getText());
			if (src.equals(srclist.get(i).getText()))
			{
				srclist.get(i).click();
			}
		}
	
		to.click();
		to.sendKeys(dstn);
		List<WebElement> dstnlist=destinationlist.findElements(By.tagName("li"));
		for (int j = 0; j < dstnlist.size(); j++)
		{
			System.out.println(dstnlist.get(j).getText());
			if (dstn.equals(dstnlist.get(j).getText()))
			{
				dstnlist.get(j).click();
			}
		}	
	}
}
