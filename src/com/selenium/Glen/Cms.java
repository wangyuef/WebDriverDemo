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
	   //����IE���
	   System.setProperty("webdriver.ie.driver","D:/java/WebDriverDemo/resources/IEDriverServer.exe");
	   DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
	   dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	   WebDriver oWebDriver = new InternetExplorerDriver(dc);
	   //����Ĭ�ϵĵȴ�ʱ��
	   WebDriverWait wait =new WebDriverWait(oWebDriver,10);
	   //ʹ��IE�������ָ����URL
	   oWebDriver.get("http://192.168.110.176:8304/cms");
	   //������������
	   oWebDriver.manage().window().maximize();
	   //�ҵ��û����ı���Ԫ�ز����
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
	   oWebDriver.findElement(By.xpath("//input[@name='name']")).clear();
	   //�ҵ��û����ı���Ԫ�ز������û���
	   oWebDriver.findElement(By.xpath("//input[@name='name']")).sendKeys("hebei");
	   //�ҵ������ı���Ԫ�ز���������
	   oWebDriver.findElement(By.xpath("//input[@name='psd']")).sendKeys("servyou126");
	   //�ҵ���¼��ťԪ�ز����
	   oWebDriver.findElement(By.xpath("//button[@type='submit']")).click();
	   //������ϵ���༭�˵�����һ��ִ�еȴ����Ҳ���Ԫ�����������趨�ĵȴ�ʱ���ڼ���Ѱ��
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/span[3]/span[2]")));
	   oWebDriver.findElement(By.xpath("//div[2]/div/span[3]/span[2]")).click();
	   //��λ�༭����ҳ��
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.id("mainframe")));
	   //������ϵ��鷢����ť
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id='createSurvey']/td/a/span")));
	   oWebDriver.findElement(By.xpath("//tr[@id='createSurvey']/td/a/span")).click();
	   //ѡ�񷢲������ͻ���
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mini-5$ck$0")));
	   oWebDriver.findElement(By.id("mini-5$ck$0")).click();
	   //�����ֹ����
	   oWebDriver.findElement(By.id("validDateEnd$text")).sendKeys("2016-04-30");
	   //ѡ�񵯴�ģʽ
	   oWebDriver.findElement(By.id("mini-18$ck$1")).click();
	   //ѡ��ģʽ��
	   //oWebDriver.findElement(By.id("mini-19$ck$1")).click();
	   //ѡ������ѡ��
	   //oWebDriver.findElement(By.id("mini-23$ck$1")).click();
	   //����˰��
	   oWebDriver.findElement(By.id("taxpayerList1$text")).sendKeys("130721106401830,130106700712762,130102054013413,130102054013333,130201507150031,130201507150032,131025755471767,130201507150033,130107098257575,650105053188449,310101132344964,310101737450823");
	   //�����һ��
	   oWebDriver.findElement(By.xpath("//a/span")).click();
	   //�������Ʋ�ѯ��
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("templateName")));
	   oWebDriver.findElement(By.id("templateName")).sendKeys("1");
	   //ѡ���ѯ���ı�
	   oWebDriver.findElement(By.xpath("//div[@id='main']/div/div/div[3]/p")).click();
	   //���ѡ�ô�ģ��
	   oWebDriver.findElement(By.xpath("//a[contains(text(),'ѡ�ô�ģ��')]")).click();
	   //��ղ�������������
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/input")));
	   oWebDriver.findElement(By.xpath("//div/div/input")).clear();
	   oWebDriver.findElement(By.xpath("//div/div/input")).sendKeys("����yanggy0421");
	   //�������Ԥ��
	   oWebDriver.findElement(By.xpath("//a[contains(text(),'����Ԥ��')]")).click();
	   //����ύ������ť
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'�ύ����')]")));
	   oWebDriver.findElement(By.xpath("//a[contains(text(),'�ύ����')]")).click();
	   //�����ʾ��ȷ����ť
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='mini-2']/span")));
	   oWebDriver.findElement(By.xpath("//a[@id='mini-2']/span")).click();
	   //�ص�Ĭ�ϵ�ҳ�潹�㣬�����˵�����֮ǰ��λ��frame�ϣ�������л�Ĭ�ϵ�ҳ�棬���Ҳ��������˵����Ԫ��
	   oWebDriver.switchTo().defaultContent();
	   //������ϵ��������˵�
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mini-4$4']/div/span[3]/span[2]")));
	   oWebDriver.findElement(By.xpath("//div[@id='mini-4$4']/div/span[3]/span[2]")).click();
	   //��λ����ҳ��
	   oWebDriver.switchTo().frame(oWebDriver.findElement(By.id("mainframe")));
	   //�����һ����¼���������ť
	   oWebDriver.findElement(By.xpath("//td[10]/span/a")).click();
	   //ѡ������ͨ��
	   oWebDriver.findElement(By.id("mini-4$ck$0")).click();
	   //ѡ��������ͨ��
	   //oWebDriver.findElement(By.id("mini-4$ck$1")).click();
	   //��ղ��޸��������
	   oWebDriver.findElement(By.id("suggestion$text")).clear();
	   oWebDriver.findElement(By.id("suggestion$text")).sendKeys("�������");
	   //���ȷ����ť
	   oWebDriver.findElement(By.xpath("//a/span")).click();
}
	
}