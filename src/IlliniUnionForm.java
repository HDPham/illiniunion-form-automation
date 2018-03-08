import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IlliniUnionForm {
	private static WebDriver driver;
	private static Properties prop;
	private static String browser;
	
	
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		
		prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(projectLocation + "/src/BoardInternMeeting.properties");
			prop.load(input);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		browser = prop.getProperty("browser");
		setBrowserConfig();
		
		driver.get("https://illiniunion.illinois.edu/EventServices/SubmitRequest.aspx");
		
		
		// Page 1
		WebElement regStuOrgRadio = driver.findElement(By.id("ContentPlaceHolder1_rblGroupType_1"));
		regStuOrgRadio.click();
		WebElement pageOneNextButton = driver.findElement(By.id("ContentPlaceHolder1_btnStep1_Next"));
		pageOneNextButton.click();
		
		
		// Page 2
		WebElement netIDText = driver.findElement(By.id("ContentPlaceHolder1_txt_netid"));
		netIDText.sendKeys(prop.getProperty("net_ID"));
		WebElement passwordText = driver.findElement(By.id("ContentPlaceHolder1_txt_password"));
		passwordText.sendKeys(prop.getProperty("password"));
		WebElement pageTwoNextButton = driver.findElement(By.id("ContentPlaceHolder1_btnSignIn"));
		pageTwoNextButton.click();
		
		
		// Page 3
		WebElement orgNameText = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_OrganizationName"));
		orgNameText.sendKeys(prop.getProperty("org_name"));
		
		WebElement regStuOrgRadio2 = driver.findElement(By.id("ContentPlaceHolder1_rbl_RSOorRO_0"));
		regStuOrgRadio2.click();
		
		WebElement otherOrgsText = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_EventPartners"));
		otherOrgsText.sendKeys(prop.getProperty("other_orgs"));
		
		WebElement authAgentText = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_AuthorizedAgent"));
		authAgentText.sendKeys(prop.getProperty("auth_agent_name"));
		
		Select authAgentOption = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlRSOandRO_AuthorizedAgentRole")));
		authAgentOption.selectByVisibleText(prop.getProperty("auth_agent_option"));
		
		WebElement primaryName = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_ContactName"));
		primaryName.sendKeys(prop.getProperty("primary_name"));
		
		WebElement primaryEmail = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_ContactEmail"));
		primaryEmail.sendKeys(prop.getProperty("primary_email"));
		
		WebElement primaryPhone = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_ContactPhone"));
		primaryPhone.sendKeys(prop.getProperty("primary_phone"));
		
		WebElement primaryUIN = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_ContactUIN"));
		primaryUIN.sendKeys(prop.getProperty("primary_UIN"));
		
		WebElement secondaryName = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_Contact2Name"));
		secondaryName.sendKeys(prop.getProperty("secondary_name"));
		
		WebElement secondaryEmail = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_Contact2Email"));
		secondaryEmail.sendKeys(prop.getProperty("secondary_email"));
		
		WebElement secondaryPhone = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_Contact2Phone"));
		secondaryPhone.sendKeys(prop.getProperty("secondary_phone"));
		
		WebElement secondaryUIN = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_Contact2UIN"));
		secondaryUIN.sendKeys(prop.getProperty("secondary_UIN"));
		
		WebElement accountNum = driver.findElement(By.id("ContentPlaceHolder1_txtRSOandRO_AccountNumber"));
		accountNum.sendKeys(prop.getProperty("account_num"));
		
		WebElement pageThreeNextButton = driver.findElement(By.id("ContentPlaceHolder1_btnStep3"));
		pageThreeNextButton.click();
		
		// Page 4
		WebElement noUnder18Radio = driver.findElement(By.id("ContentPlaceHolder1_rblPrimaryNonUIUCUnder18_1"));
		noUnder18Radio.click();
		WebElement noMoneyRadio = driver.findElement(By.id("ContentPlaceHolder1_rblEntryFee_1"));
		noMoneyRadio.click();
		WebElement noFundRaiserRadio = driver.findElement(By.id("ContentPlaceHolder1_rblFundraiser_1"));
		noFundRaiserRadio.click();
		WebElement noNonUIUCSpeakerRadio = driver.findElement(By.id("ContentPlaceHolder1_rblNonUIUCSpeaker_1"));
		noNonUIUCSpeakerRadio.click();
		WebElement noNonUIUCIndividualsRadio = driver.findElement(By.id("ContentPlaceHolder1_rblNonUIUCAttending_1"));
		noNonUIUCIndividualsRadio.click();
		WebElement noFoodDrinkRadio = driver.findElement(By.id("ContentPlaceHolder1_rblServeFood_1"));
		noFoodDrinkRadio.click();
		WebElement doNotIncludeCalendarRadio = driver.findElement(By.id("ContentPlaceHolder1_rblStep3_MasterCalendar_3"));
		doNotIncludeCalendarRadio.click();
		WebElement pageFourNextButton = driver.findElement(By.id("ContentPlaceHolder1_btnStep4"));
		pageFourNextButton.click();
		
		// Page 5
		WebElement meetingRadio = driver.findElement(By.id("ContentPlaceHolder1_rblTypeofEvent_0"));
		meetingRadio.click();
		WebElement pageFiveNextButton = driver.findElement(By.id("ContentPlaceHolder1_btnNextStep4"));
		pageFiveNextButton.click();
		
		// Page 6
		WebElement eventTitleText = driver.findElement(By.id("ContentPlaceHolder1_txtMeeting_EventTitle"));
		eventTitleText.sendKeys(prop.getProperty("event_title"));
		WebElement eventDescriptionTextArea = driver.findElement(By.id("ContentPlaceHolder1_txtMeeting_EventDescription"));
		eventDescriptionTextArea.sendKeys(prop.getProperty("event_description"));
		Select dateSetupOption = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlMeeting_DateChoices")));
		dateSetupOption.selectByValue(prop.getProperty("date_setup_option"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement dateTd = driver.findElement(By.xpath("//table[@class=\"calendarMonthDefault\"]/tbody/tr[6]/td[1]"));
		dateTd.click();
		WebElement alternativeDatesText = driver.findElement(By.id("ContentPlaceHolder1_txtMeeting_AlternateDates1"));
		alternativeDatesText.sendKeys(prop.getProperty("alternative_dates"));
		Select arriveOption = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlMeeting_ClientArrivalTime1")));
		arriveOption.selectByValue(prop.getProperty("arrive"));
		Select startOption = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlMeeting_EventStartTime1")));
		startOption.selectByValue(prop.getProperty("start"));
		Select endOption = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlMeeting_EventEndTime1")));
		endOption.selectByValue(prop.getProperty("end"));
		Select departureOption = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlMeeting_ClientDepartureTime1")));
		departureOption.selectByValue(prop.getProperty("departure"));
		WebElement conferenceRadio = driver.findElement(By.id("ContentPlaceHolder1_rblMeeting_SetupType1_1"));
		conferenceRadio.click();
		WebElement roomsTextArea = driver.findElement(By.id("ContentPlaceHolder1_txtMeeting_PreferredRoom1"));
		roomsTextArea.sendKeys(prop.getProperty("rooms"));
		WebElement noAudioSupportRadio = driver.findElement(By.id("ContentPlaceHolder1_rblMeeting_AVEquipNeeded1_1"));
		noAudioSupportRadio.click();
		WebElement pageSixNextButton = driver.findElement(By.id("ContentPlaceHolder1_btnMeeting_Next"));
		pageSixNextButton.click();
		
	}
	
	
	public static void setBrowserConfig() {
		String projectLocation = System.getProperty("user.dir");

		if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "/lib/geckodriver/geckodriver");
			System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
//			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
	}
}
