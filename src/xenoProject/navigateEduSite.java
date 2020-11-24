package xenoProject;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
  
public class navigateEduSite {  
  
    public static void main(String[] args) throws Exception {  
      
           // System Property for Chrome Driver   
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");  
          
             // Instantiate a ChromeDriver class.     
        WebDriver driver=new ChromeDriver();  
          
           // Launch Website  
        driver.navigate().to("https://www.khanacademy.org/");  
          
         //Maximize the browser  
          driver.manage().window().maximize();  
          
      
        //Count the number of links on the website using anchor tag
        String url = "https://www.khanacademy.org/"; 
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links on the Website is: " + links.size());
        
      ArrayList<String> hrefs = new ArrayList<String>(); 
           
        //Displaying each link
           for (WebElement var : links)
           {
               System.out.println(var.getText()); 
               System.out.println(var.getAttribute("href"));
               hrefs.add(var.getAttribute("href")); 
           }

        //Navigating to each link
           int i=0;
           for (String href : hrefs)
           {
               driver.navigate().to(href);
               System.out.println((++i)+":The link is: "+href);
               Thread.sleep(3000); 
           }
          
        //Navigating back to main page   
           driver.navigate().to("https://www.khanacademy.org/");
           
        //Closing browser window
           driver.quit();
       
	}
}

