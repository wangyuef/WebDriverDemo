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

public class Cms {
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
	   oWebDriver.get("http://192.168.110.176:8304/cms");
	   //浏览器窗口最大化
	   oWebDriver.manage().window().maximize();
	   //找到用户名文本框元素并清空
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
	   oWebDriver.findElement(By.xpath("//input[@name='name']")).clear();
	   //找到用户名文本框元素并输入用户名
	   oWebDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("hebei");
	   //找到密码文本框元素并输入密码
	   oWebDriver.findElement(By.xpath("//input[@name='psd']")).sendKeys("servyou126");
	   //找到登录按钮元素并点击
	   oWebDriver.findElement(By.xpath("//button[@type='submit']")).click();
	   //点击网上调查编辑菜单，第一行执行等待，找不到元素则在上面设定的等待时间内继续寻找
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/span[3]/span[2]")));
	   oWebDriver.findElement(By.xpath("//div[2]/div/span[3]/span[2]")).click();
	   //定位编辑管理页面
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.id("mainframe")));
	   //点击网上调查发布按钮
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id='createSurvey']/td/a/span")));
	   oWebDriver.findElement(By.xpath("//tr[@id='createSurvey']/td/a/span")).click();
	   //选择发布渠道客户端
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mini-5$ck$0")));
	   oWebDriver.findElement(By.id("mini-5$ck$0")).click();
	   //输入截止日期
	   oWebDriver.findElement(By.id("validDateEnd$text")).sendKeys("2016-04-30");
	   //选择弹窗模式
	   oWebDriver.findElement(By.id("mini-18$ck$1")).click();
	   //选择模式窗
	   //oWebDriver.findElement(By.id("mini-19$ck$1")).click();
	   //选择条件选择
	   //oWebDriver.findElement(By.id("mini-23$ck$1")).click();
	   //输入税号
	   oWebDriver.findElement(By.id("taxpayerList1$text")).sendKeys("130721106401830,130106700712762,130102054013413,130102054013333,130201507150031,130201507150032,131025755471767,130201507150033,130107098257575,650105053188449,310101132344964,310101737450823");
	   //点击下一步
	   oWebDriver.findElement(By.xpath("//a/span")).click();
	   //输入名称查询表单
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("templateName")));
	   oWebDriver.findElement(By.id("templateName")).sendKeys("1");
	   //选择查询出的表单
	   oWebDriver.findElement(By.xpath("//div[@id='main']/div/div/div[3]/p")).click();
	   //点击选用此模板
	   oWebDriver.findElement(By.xpath("//a[contains(text(),'选用此模板')]")).click();
	   //清空并重新命名标题
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/input")));
	   oWebDriver.findElement(By.xpath("//div/div/input")).clear();
	   oWebDriver.findElement(By.xpath("//div/div/input")).sendKeys("弹窗yanggy0421");
	   //点击发布预览
	   oWebDriver.findElement(By.xpath("//a[contains(text(),'发布预览')]")).click();
	   //点击提交审批按钮
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'提交审批')]")));
	   oWebDriver.findElement(By.xpath("//a[contains(text(),'提交审批')]")).click();
	   //点击提示窗确定按钮
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='mini-2']/span")));
	   oWebDriver.findElement(By.xpath("//a[@id='mini-2']/span")).click();
	   //回到默认的页面焦点，审批菜单不在之前定位的frame上，如果不切回默认的页面，则找不到审批菜单这个元素
	   oWebDriver.switchTo().defaultContent();
	   //点击网上调查审批菜单
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mini-4$4']/div/span[3]/span[2]")));
	   oWebDriver.findElement(By.xpath("//div[@id='mini-4$4']/div/span[3]/span[2]")).click();
	   //定位审批页面
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.id("mainframe")));
	   //点击第一条记录后的审批按钮
	   oWebDriver.findElement(By.xpath("//td[10]/span/a")).click();
	   //选择审批通过
	   oWebDriver.findElement(By.id("mini-4$ck$0")).click();
	   //选择审批不通过
	   //oWebDriver.findElement(By.id("mini-4$ck$1")).click();
	   //清空并修改审批意见
	   oWebDriver.findElement(By.id("suggestion$text")).clear();
	   oWebDriver.findElement(By.id("suggestion$text")).sendKeys("审批意见");
	   //点击确定按钮
	   oWebDriver.findElement(By.xpath("//a/span")).click();
}
	
}