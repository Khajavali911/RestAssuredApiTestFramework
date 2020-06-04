package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Pet;
import io.cucumber.datatable.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

public class GetPostDeletePetSteps {
	public static ResponseOptions<Response> response;
    public static String token;
	@Given("^I ensure to Perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) throws Throwable {
    	try {
        List<String> data = table.row(0);
    		 	
        Map<String, String> body = new HashMap<String,String>();
      
        body.put("id",data.get(0));
        		
        body.put("name",data.get(1));
        body.put("status", data.get(2)); 
     
        response= RestAssuredExtension.PostOpsWithBody(url, body);
      
        if(response.getStatusCode() == 200)
        {
        	 // BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Given: I ensure to Perform POST operation for "+url).pass("Updated pet details as ID " +data.get(0)+" Name "+data.get(1) + " Status " +data.get(2));
        }
        //Perform post operation
      //  response= restassured.PostOpsWithBody(url, );
    	}
    	catch(Exception ex) {
    		
    		String msg =ex.getMessage();
    	}
    }
	@Then("I should get availble pet list")
    public void ValidateAvailablePetList()
    {
    String s=	response.getBody().jsonPath().get().toString();
    List<Pet> pets =new ArrayList<Pet>();
    pets=	response.getBody().as(pets.getClass());  
	    if(response.getStatusCode() == 200)
	    {
	    	//  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Then: I should get availble pet list").pass("Availbale Pets list successfully retrived");
	    }
    }
	@And("^I Perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url,io.cucumber.datatable.DataTable table) throws Throwable {
    	List<String> data = table.row(0);
        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("id", data.get(0));
        response =RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
       // RestAssuredExtention restassured =new RestAssuredExtention(url, APIConstant.ApiMethods.DELETE,null);
        //Perform Delete operation
       
        if(response.getStatusCode() == 200)
	    {
	    	//  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I Perform DELETE operation for id " +data.get(0)).pass("pet successfuly deleted");
	    }
        else {
        	 // BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I Perform DELETE operation for id " +data.get(0)).fail("pet deletion unsuccessful");
        }
    }
	 @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
	    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) throws Throwable {
		 List<String> data = table.row(0);

	         Map<String, String> pathParams = new HashMap<String, String>();
	         pathParams.put("id", data.get(0));
	        
	         response = RestAssuredExtension.GetWithPathParams(url, pathParams);
	       
	        Pet pet =new Pet();
	        pet=	response.getBody().as(pet.getClass());  
	        
	        if(response.getStatusCode() == 200)
		    {
		    //	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I perform GET operation with path parameter for " +data.get(0)).pass("pet details as "+ pet.getId()+" pet name "+pet.getName()+" pet status "+ pet.getStatus());
		    }
	        else {
	        //	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I perform GET operation with path parameter for " +data.get(0)).fail("unable get pet details");
	        }
	    }
	    

}
