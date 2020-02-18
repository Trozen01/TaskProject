package Task;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ShopingWebsite {
public static String url; 	
public static WebDriver dr;

@Test
public void Task() throws InterruptedException {
	
try {
	
	
	url ="http://automationpractice.com/index.php";
    System.out.println(System.getProperty("user.dir"));

	//1.lunch driver.    
    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Browserexe\\chromedriver.exe");
	
	//2.open crome driver.
    dr =  new ChromeDriver();	
    dr.get(url);
    dr.manage().window().maximize();
    dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    Thread.sleep(2000);
    
    String Emailid ="abcd40.jitendra0@gmail.com";
    
    dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account' and @title='Log in to your customer account']")).click();
 

    //type email id 
    dr.findElement(By.xpath("//input[@id='email_create']")).sendKeys(Emailid);
    
    //click on create an account.
    dr.findElement(By.id("SubmitCreate")).click();
    
    //Click on title redio button
    dr.findElement(By.id("id_gender1")).click();
    
    dr.findElement(By.id("customer_firstname")).sendKeys("A");
    
    dr.findElement(By.id("customer_lastname")).sendKeys("A");
    
    dr.findElement(By.id("passwd")).sendKeys("Abcde");
    
    //Using Select class for selecting value from dropdown  
    Select dropdownday = new Select(dr.findElement(By.id("days")));  
    dropdownday.selectByValue("1");
    
    Select dropdownmonth = new Select(dr.findElement(By.id("months")));  
    dropdownmonth.selectByValue("11");
    
    Select dropdownyear = new Select(dr.findElement(By.id("years")));  
    dropdownyear.selectByValue("1991");
    
  
    dr.findElement(By.xpath("//input[@id='newsletter']")).click();
    dr.findElement(By.xpath("//input[@id='optin']")).click();
    
    dr.findElement(By.id("company")).sendKeys("ABCLtd");
    
    dr.findElement(By.id("address1")).sendKeys("Address1");
    dr.findElement(By.id("address2")).sendKeys("Address2");
    dr.findElement(By.id("city")).sendKeys("Mumbai");
    
    Select dropdownstate = new Select(dr.findElement(By.id("id_state")));  
    dropdownstate.selectByValue("14");
    dr.findElement(By.id("postcode")).sendKeys("40093");
    
    Select dropdowncountry = new Select(dr.findElement(By.id("id_country")));  
    dropdowncountry.selectByValue("21");
    
    dr.findElement(By.id("phone_mobile")).sendKeys("1234567789");
    dr.findElement(By.id("alias")).sendKeys("MyAddress");
    dr.findElement(By.id("submitAccount")).click();
  
    //Log out.
    dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout=' and @title='Log me out']")).click();
    
    
    //Log In.
    dr.findElement(By.id("email")).sendKeys(Emailid);
    dr.findElement(By.id("passwd")).sendKeys("Abcde");
    dr.findElement(By.id("SubmitLogin")).click();
    
    
    Actions action = new Actions(dr);
    WebElement women = dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category' and @title='Women']"));
    action.moveToElement(women).perform();
    
    
    dr.findElement(By.xpath("//a[@title='Women']//parent::li//ul//ul//li[1]//a[@title='T-shirts']")).click();
    
    dr.findElement(By.xpath("//*[@id='center_column']//ul//li//div//div[1]//div//a[1]//img")).click();
    
    
   dr.switchTo().frame(0);
   Thread.sleep(3000);
   
   dr.findElement(By.xpath("//form[@id='buy_block']//div//p//a//i[@class='icon-plus']")).click();
    
   dr.findElement(By.xpath("//p[@id='add_to_cart']")).click();

   dr.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();

   

   String productprice =  dr.findElement(By.id("total_product")).getText();
   String replace = productprice.replace("$","");
   float  Productprice = Float.valueOf(replace.trim());
   System.out.println("Two Tshart price: "+Productprice);

   String productchar = dr.findElement(By.id("total_shipping")).getText();
   String replaceone = productchar.replace("$","");
   float  Productpriceone = Float.valueOf(replaceone.trim());
   System.out.println("Total shipment charges is:-" +Productpriceone);
   
   String producttotpurch = dr.findElement(By.id("total_price_container")).getText();
   String replacethree = producttotpurch.replace("$","");
   float  totalprice = Float.valueOf(replacethree.trim());
   System.out.println("Total Price of Tow Tshart and shiping charges is " +totalprice);
          
   
   if(totalprice >= 0){
	   
	   
	   float Vertotalprice = Float.sum(Productprice,Productpriceone);
	   
	   if(Vertotalprice == totalprice)
	   {
		   System.out.println("Total cost of Two Tshart and shipment chartes match with total invoice Amount ");
	   }
	   else
	   {
		   System.out.println("Total cost of Two Tshart and shipment chartes not match with total invoice Amount ");
	   }
		   
   }
   else{
	   
	   System.out.println("Please do the check out process properlly");
   }


   dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")).click();
   dr.findElement(By.xpath("//button[@name='processAddress']")).click();
   
   dr.findElement(By.id("cgv")).click();
   dr.findElement(By.xpath("//button[@name='processCarrier']")).click();
 
   dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment'] ")).click();
   dr.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
   
   
   String  ab = dr.findElement(By.xpath("//*[@id='center_column']/div")).getText();
   System.out.println(ab);
   
   String[] arrOfStr = ab.split("reference "); 
   
   String a = arrOfStr[1];
   
   String[] arrOfStrr = a.split(" ");
   
   String referanceNo = arrOfStrr[0];
   
   System.out.println(referanceNo); 
 
   
   //Go to Order history and details.
   dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account' and @title='View my customer account']")).click();
   dr.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=history' and @title='Orders']")).click();
 
   
  WebElement ToGetRows  = dr.findElement(By.xpath("//table[@id='order-list']//tbody"));
  List<WebElement>TotalRowsList = ToGetRows.findElements(By.tagName("tr"));
  System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());


   WebElement arf  = dr.findElement(By.xpath("//table[@id='order-list']/tbody/tr/td"));
   String tableValue = arf.getText();
   System.out.println("Col value is : " + tableValue);
   
   Thread.sleep(2000);

   arf.click();
   
   String Invoicevalue =dr.findElement(By.xpath("//*[@id='order-detail-content']/table/tfoot/tr[4]/td[2]/span")).getText();
   String Invoicevaluenew = producttotpurch.replace("$","");
   float  Invoiceprice = Float.valueOf(Invoicevaluenew.trim());
   
   System.out.println("Order place price" +totalprice);
   System.out.println("Invoice price " +Invoiceprice);
   
   if(totalprice == Invoiceprice){
	   
	   System.out.println("test case is pass");
   }
   else{
	   
	   System.out.println("test case is fail");
   }
   
    dr.close();
    
	} catch (Exception e) {
		
		System.out.println("Exception is:- " + e);
	}

}
}
