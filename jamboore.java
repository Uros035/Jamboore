import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class jamboore {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Programiranje\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.casinojamboree.com/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerdriver=driver.findElement(By.xpath("/html/body/footer"));
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement coloumndriver=footerdriver.findElement(By.xpath("/html/body/footer/div[1]/div[3]"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}// opens all the tabs
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())
		{
			
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		
		}
		
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().window(originalWindow);
			
		
		File src=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//da uzmem sliku ekrana
		FileUtils.copyFile(src,new File("C:\\Screenshot selenium\\screenshot.png"));
		Thread.sleep(4000L);
		String originalHandle = driver.getWindowHandle();

	    //Do something to open new tabs

	    for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }

	    driver.switchTo().window(originalHandle);
	    Thread.sleep(2000L);
	    driver.findElement(By.xpath("/html/body/header/div[3]/ul/li[4]/a")).click();
	    Thread.sleep(2000L);
	    driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div[1]/nav/ul/li[3]")).click();
	    driver.findElement(By.id("game-search")).sendKeys("a");
	    driver.findElement(By.id("game-search-btn")).click();
	    Thread.sleep(2000L);
	    Actions a =new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div/img"))).build().perform();
	    
	    //driver.findElement(By.xpath("/html/body/main/div[2]/div[4]/div")).click();
	    driver.findElement(By.cssSelector("a[name$='free']")).click();
	    String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	    String subWindowHandler = null;

	    Set<String> handles = driver.getWindowHandles(); // get all window handles
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	        subWindowHandler = iterator.next();
	    }
	    driver.switchTo().window(subWindowHandler);
	    Thread.sleep(8000L);
	    driver.findElement(By.id("ContinueButton")).click();
	    Thread.sleep(2000L);
	    File src1=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//da uzmem sliku ekrana
		FileUtils.copyFile(src1,new File("C:\\Screenshot selenium\\screenshot1.png"));
		Thread.sleep(2000L);
	    driver.close();
	    driver.switchTo().window(parentWindowHandler);
	    driver.findElement(By.xpath("/html/body/header/div[3]/ul/li[5]/a")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/nav/ul[1]/li[2]")).click();
		Actions a2 =new Actions(driver);
		a2.moveToElement(driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[4]/div[1]/img"))).build().perform();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[3]/ul/li[4]")).click();
		//driver.findElement(By.xpath(""))
		System.out.println(driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[3]/ul/li[4]")).getText());//page nmb
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/nav/ul[1]/li[3]")).click();
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/nav/ul[1]/li[4]")).click();
		driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div[2]/div/nav/ul[2]/li[7]")).click();
		driver.findElement(By.id("game-search")).sendKeys("ab");
		driver.findElement(By.id("game-search-btn")).click();
		Thread.sleep(2000L);
		File src2=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//da uzmem sliku ekrana
		FileUtils.copyFile(src2,new File("C:\\Screenshot selenium\\screenshot2.png"));
		
		driver.findElement(By.xpath("/html/body/header/div[3]/ul/li[6]/a")).click();
		Thread.sleep(2000L);
		
		File src3=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//da uzmem sliku ekrana
		FileUtils.copyFile(src3,new File("C:\\Screenshot selenium\\screenshot3.png"));
		driver.findElement(By.xpath("/html/body/header/div[1]/div[4]")).click();
		driver.findElement(By.xpath("/html/body/header/div[1]/div[5]/div[2]/div[2]/form/div[7]/div/a")).click();
		//registration
		driver.findElement(By.id("JapanRegistrationForm_username")).sendKeys("Ukica1");
		driver.findElement(By.id("JapanRegistrationForm_firstname")).sendKeys("Uksi");
		driver.findElement(By.id("JapanRegistrationForm_lastname")).sendKeys("Ukica");
		driver.findElement(By.id("JapanRegistrationForm_password")).sendKeys("Ukica123");
		driver.findElement(By.id("JapanRegistrationForm_confirm_password")).sendKeys("Ukica123");
		driver.findElement(By.id("JapanRegistrationForm_email")).sendKeys("Ukica@yopmail.com");
		driver.findElement(By.id("JapanRegistrationForm_confirm_email")).sendKeys("Ukica@yopmail.com");
		driver.findElement(By.id("JapanRegistrationForm_birthdate")).sendKeys("2002/01/01");
		driver.findElement(By.id("JapanRegistrationForm_phone")).sendKeys("111111111");
		driver.findElement(By.id("JapanRegistrationForm_zipcode")).sendKeys("1111");
		WebElement staticDropdown = driver.findElement(By.id("JapanRegistrationForm_prefecture"));
		Select dropdown =new Select(staticDropdown);
		dropdown.selectByValue("hokkaido");
		//driver.findElement(By.id("JapanRegistrationForm_prefecture")).click();
		//driver.findElement(By.id("/html/body/main/div/div[1]/form/div[14]/div/div/select/option[1]")).click();
		driver.findElement(By.id("JapanRegistrationForm_city")).sendKeys("Ukica");
		driver.findElement(By.id("JapanRegistrationForm_address")).sendKeys("Ukisa");
		driver.findElement(By.id("JapanRegistrationForm_term_conditions")).click();
		Thread.sleep(2000L);
		File src4=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//da uzmem sliku ekrana
		FileUtils.copyFile(src4,new File("C:\\Screenshot selenium\\screenshot4.png"));
		Actions a3 =new Actions(driver);
		a3.moveToElement(driver.findElement(By.xpath("/html/body/header/div[1]/h1/a/img"))).build().perform();
		
		
			//String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			//coloumndriver.findElements(By.xpath("/html/body/header/div[1]/h1/a")).get(1).sendKeys(clickonlinkTab);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.xpath("/html/body/header/div[1]/h1/a")).sendKeys(selectLinkOpeninNewTab);
		//driver.close();
		
		Set<String> windows = driver.getWindowHandles(); //parentid,childid,subchildId
		Iterator<String>it1 = windows.iterator();
		String parentId = it1.next();
		String childId = it1.next();
		driver.switchTo().window(childId);
		
		
		driver.findElement(By.xpath("/html/body/header/div[1]/div[4]")).click();
		
				
	    
		  }
		    }
		
		
		
		

	


