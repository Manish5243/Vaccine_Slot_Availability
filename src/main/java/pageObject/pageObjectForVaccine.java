package pageObject;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageObjectForVaccine {

	WebDriver driver;
	public void LaunchBrowser() throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "H:/DSandALGO/Selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.cowin.gov.in");
		driver.manage().window().maximize();
		//Thread.sleep(3000);


	}

	public void AreaDetail() throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(text(),'Search by PIN')]")).click();
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("812001");


	}



	int count = 3;
	public void vaccineDetail() throws InterruptedException {


		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(2000);

		List<WebElement> Aval = driver.findElements(By.xpath("(//h5[contains(text(),'ZilaSchool BHAGALPUR -1 -18-44')]//parent::div//parent::div//parent::div/div[2]/ul/li/div/div/a)[2]"));
		int ElemPresent =  Aval.size();
		System.out.println(ElemPresent);
		

		if (ElemPresent>0) {
			String NumebrOfAvailable = driver.findElement(By.xpath("(//h5[contains(text(),'ZilaSchool BHAGALPUR -1 -18-44')]//parent::div//parent::div//parent::div/div[2]/ul/li/div/div/a)[2]")).getText();
			//(//h5[contains(text(),'JLNMCH Covishield')]//parent::div//parent::div//parent::div/div[2]/ul/li/div/div[1]/div/span)[1]
			System.out.println(NumebrOfAvailable);
			
			//Booked

			if (NumebrOfAvailable.equalsIgnoreCase("NA") || NumebrOfAvailable.equalsIgnoreCase("Booked")) {

				Thread.sleep(50000);
				vaccineDetail();	

			}
			
		}
		else {

			while(count > 0) {
				SentMail();
				count = count - 1; 

			}

			driver.close();
		}

}

//>0


	public void SentMail() {

		String to = "gcpformanish1@gmail.com"; // to address. It can be any like gmail, hotmail etc.
		final String from = "gcpformanish1@gmail.com"; // from address. As this is using Gmail SMTP.
		final String password = "Manish5243@"; // password for from mail address. 

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Vaccine Dose");
			message.setText("Go Fast and Vaccinate yourself"); 


			Transport.send(message);

			System.out.println("Mail successfully sent..");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}	
}
