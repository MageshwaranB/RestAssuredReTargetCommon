package jsonPayload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ComplexPayloadUsingMapAndList 
{
	@Test
	public void complexPayloadWithRestAssured() {
		//parent json payload
		List<Map<String, Object>> finalPayload=new ArrayList<>();
		
		Map<String, Object> firstIdGeneralDetailsMap=new LinkedHashMap<>();
		firstIdGeneralDetailsMap.put("id", 1);
		firstIdGeneralDetailsMap.put("first_name", "Maurie");
		firstIdGeneralDetailsMap.put("last_name", "Clunie");
		firstIdGeneralDetailsMap.put("email", "mclunie0@reddit.com");
		firstIdGeneralDetailsMap.put("gender", "Female");
		firstIdGeneralDetailsMap.put("married", false);
		firstIdGeneralDetailsMap.put("salary_per_month", 20000);
		
		
		Map<String, Object> firstMobileMap=new LinkedHashMap<>();
		firstMobileMap.put("primary_number", "247-130-1527");
		firstMobileMap.put("secondary_number", "452-234-1123");
		firstIdGeneralDetailsMap.put("mobile_numbers", firstMobileMap);
		
		List<Integer> firstIdYOPDetails=new LinkedList<>();
		firstIdYOPDetails.add(2014);
		firstIdYOPDetails.add(2016);
		firstIdYOPDetails.add(2020);
		
		firstIdGeneralDetailsMap.put("year_of_passed_out_details", firstIdYOPDetails);
		
		Map<String, Object> firstSkillSet=new LinkedHashMap<>();
		firstSkillSet.put("name", "Testing");
		firstSkillSet.put("proficiency", "medium");
		firstSkillSet.put("certification_done", false);
		
		firstIdGeneralDetailsMap.put("skills", firstSkillSet);
		
		//System.out.println(firstIdGeneralDetailsMap);
		
		Map<String, Object> secondIdGeneralDetails=new LinkedHashMap<>();
		
		secondIdGeneralDetails.put("id", 2);
		secondIdGeneralDetails.put("first_name", "Ennis");
		secondIdGeneralDetails.put("last_name", "Gaul");
		secondIdGeneralDetails.put("email", "egaul1@bluehost.com");
		secondIdGeneralDetails.put("gender", "Male");
		secondIdGeneralDetails.put("married", true);
		secondIdGeneralDetails.put("salary_per_month", 45000);
		
		Map<String, Object> secondMobileMap=Map.of(
				"primary_number","670-173-3819",
				"secondary_number",false
				);
		
		secondIdGeneralDetails.put("mobile_numbers", secondMobileMap);
		//System.out.println(secondIdGeneralDetails);
		List<Integer> secondYOPDetails=Arrays.asList(2015,2017,2021);
		secondIdGeneralDetails.put("year_of_passed_out_details", secondYOPDetails);
		List<Map<String, Object>> totalSkills=new ArrayList<>();
		Map<String, Object> firstSkill=Map.of("name","Testing"
									,"proficiency","high"
									,"certification_done",true);
		Map<String, Object> secondSkill=Map.of("name","Java8",
												"proficiency","low",
												"certification_done",false);
		totalSkills.add(firstSkill);
		totalSkills.add(secondSkill);
		//System.out.println(totalSkills);
		secondIdGeneralDetails.put("skills", totalSkills);
		
		//System.out.println(secondIdGeneralDetails);
		finalPayload.add(firstIdGeneralDetailsMap);
		finalPayload.add(secondIdGeneralDetails);
		
		//System.out.println(finalPayload);
		
		RestAssured.given()
						.log().all()
						.body(finalPayload)
					.when()
						.post()
					.then() 
						.log().all();
	}
}
