package com.selenium.Glen;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelloWorld {
	@Test
public void test()
{
	   //加载IE插件
	   System.setProperty("webdriver.ie.driver","D:/java/WebDriverDemo/resources/IEDriverServer.exe");
	   DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
	   dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	   WebDriver oWebDriver = new InternetExplorerDriver(dc);
	   //设置默认的等待时间
	   WebDriverWait wait =new WebDriverWait(oWebDriver,10);
	   //使用IE浏览器打开指定的URL
	   oWebDriver.get("http://192.168.150.115:6001/HbGlpt/pages/adminLogin.html");
	   //浏览器窗口最大化
	   oWebDriver.manage().window().maximize();
	   //找到用户名文本框元素并清空
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
	   oWebDriver.findElement(By.id("username")).clear();
	   //找到用户名文本框元素并输入用户名
	   oWebDriver.findElement(By.id("username")).sendKeys("jsb");
	   //找到密码文本框元素并输入密码
	   oWebDriver.findElement(By.id("password")).sendKeys("cccaaa");
	   //找到登录按钮元素并点击
	   oWebDriver.findElement(By.id("submit")).click();
	   //点击河北纳服平台菜单，第一行执行等待，找不到元素则在上面设定的等待时间内继续寻找
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mini-4$1']/div")));
	   oWebDriver.findElement(By.xpath("//div[@id='mini-4$1']/div")).click();
	   //点击内容管理菜单
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mini-6$1']/div/a")));
	   oWebDriver.findElement(By.xpath("//div[@id='mini-6$1']/div/a")).click();
	   //点击信息报送菜单
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[8]/div/a")));
	   oWebDriver.findElement(By.xpath("//div[8]/div/a")).click();
	   //点击编辑管理菜单
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/span[4]/span[2]")));
	   oWebDriver.findElement(By.xpath("//div[2]/div/span[4]/span[2]")).click();
	   //定位编辑管理页面
	   oWebDriver.switchTo().frame("contentIframe");
	   //点击新增按钮
	   oWebDriver.findElement(By.xpath("//div/a/span")).click();
	   //找到信息报送编辑页面窗口
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src,'htmls/activity_add.jsp')]")));
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.xpath("//iframe[contains(@src,'htmls/activity_add.jsp')]")));
	   //找到信息报送名称元素并输入内容
	   oWebDriver.findElement(By.id("activity_name$text")).sendKeys("信息报送名称ygy004");
	   //找到信息报送描述元素并输入内容
	   oWebDriver.findElement(By.id("activity_desc$text")).sendKeys("信息报送描述");
	   //找到下发表单复选框元素并单击选中
	   oWebDriver.findElement(By.id("mini-70$check")).click();
	   //找到选择表单模板元素并单击
	   oWebDriver.findElement(By.id("reportForm-btn")).click();
	   //定位表单选择页面
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src,'htmls/activity_formtempl.jsp')]")));
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.xpath("//iframe[contains(@src,'htmls/activity_formtempl.jsp')]")));
	   //选中表单模板
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mini-17$checkcolumn$7")));
	   oWebDriver.findElement(By.id("mini-17$checkcolumn$7")).click();
	   //点击确定按钮
	   oWebDriver.findElement(By.xpath("//div[2]/a/span")).click();
	   //回到信息报送编辑页面，这里先回到默认的frame，然后切换到编辑管理页面，最后切换回到编辑界面
	   oWebDriver.switchTo().defaultContent();
	   oWebDriver.switchTo().frame("contentIframe");
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.xpath("//iframe[contains(@src,'htmls/activity_add.jsp')]")));
	   //选中重复上报
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mini-85$check")));
	   oWebDriver.findElement(By.id("mini-85$check")).click();
	   //选中同时上报
	   oWebDriver.findElement(By.id("mini-86$check")).click();
	   //选择指定税号
	   oWebDriver.findElement(By.id("mini-87$ck$1")).click();
	   //输入税号
	   oWebDriver.findElement(By.id("list$text")).sendKeys("130102197807241833;130107098257575");
	   //去掉截止日期input标签的readonly属性
	   JavascriptExecutor removeAttribute = (JavascriptExecutor)oWebDriver;
	   removeAttribute.executeScript("var setDate=document.getElementById(\"hdsj$text\");setDate.removeAttribute('readonly');") ;
       //向截止日期输入框赋值，这里直接赋值会因为丢失焦点无效，故先找到父节点再回来进行赋值操作
	   oWebDriver.findElement(By.id("hdsj$text")).findElement(By.xpath("..")).click(); 
       oWebDriver.findElement(By.id("hdsj$text")).sendKeys("2016-05-24");
       //点击提交审批按钮
       oWebDriver.findElement(By.xpath("//div[2]/div/div/a[2]/span")).click();  
       //回到默认frame
       oWebDriver.switchTo().defaultContent();
       //点击审批管理菜单
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mini-6$33']/div/span[4]/span[2]")));
	   oWebDriver.findElement(By.xpath("//div[@id='mini-6$33']/div/span[4]/span[2]")).click();
	   //定位到审批管理页面
	   oWebDriver.switchTo().frame("contentIframe");
	   //点击第一条记录的审批按钮  
	   oWebDriver.findElement(By.xpath("//td[9]/span/a")).click(); 
	   //定位到审批页面
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src,'htmls/activity_audit.jsp')]")));
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.xpath("//iframe[contains(@src,'htmls/activity_audit.jsp')]")));
	   //点击审批通过按钮 
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='mini-57$ck$0']")));
	   oWebDriver.findElement(By.xpath("//input[@id='mini-57$ck$0']")).click();
	   //点击审批不通过按钮 
	   //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='mini-57$ck$1']")));
	   //oWebDriver.findElement(By.xpath("//input[@id='mini-57$ck$1']")).click();
	   //点击确定按钮
	   oWebDriver.findElement(By.xpath("//td/a/span")).click(); 
}
	
}