Feature: Application Login

	Scenario: Home Page default login
		Given User is on Netbanking landing apge
		When User login into application with username and password
		Then Home page is populated
		And Cards are displayed
		
	
	@AvailableVaccine
	Scenario: Verify vaccine availabilty on coWin site
		Given User land on the cowin site
		When User give area deatil and click enter
		Then User check the vaccine availabilty and send mail to user
		  
	