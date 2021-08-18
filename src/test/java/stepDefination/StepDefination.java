package stepDefination;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObject.pageObjectForVaccine;

@RunWith(Cucumber.class)
public class StepDefination {
	
	
	pageObjectForVaccine POV = new pageObjectForVaccine();
	
	@Given("^User is on Netbanking landing apge$")
	public void User_is_on_Netbanking_landing_apge() {
		System.out.println("Hello Login succesfully");
	}
	@When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
		System.out.println("Hello Login With user name and password");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
    	System.out.println("Hello HomePage Populate");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
    	System.out.println("Hello Card dispay");
    }
    
    
    
    
    
    @Given("^User land on the cowin site$")
    public void user_land_on_the_cowin_site() throws Throwable {
    	POV.LaunchBrowser();
    }

    @When("^User give area deatil and click enter$")
    public void user_give_area_deatil_and_click_enter() throws Throwable {
        POV.AreaDetail();
    }

    @Then("^User check the vaccine availabilty and send mail to user$")
    public void user_check_the_vaccine_availabilty_and_send_mail_to_user() throws Throwable {
        POV.vaccineDetail();
    }
}
