package pojoExamples.jsonToJavaObjects;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class GhibiliApiGetFilms 
{
	public static void main(String[] args) {
		List<GhibliFilms> ghibliFilmsList = RestAssured.given()
						.log().all()
					.when()
						.get("https://ghibliapi.herokuapp.com/films")
						.as(new TypeRef<List<GhibliFilms>>() {
						})
					;
		System.out.println(ghibliFilmsList.get(0).getDirector());
		
		List<String> directorsList=new LinkedList<>();
		
		for(GhibliFilms ghibiliFilms:ghibliFilmsList) {
				directorsList.add(ghibiliFilms.getDirector());
		}
		
		directorsList.forEach(System.out::println);
		
		HashSet<String> set=new HashSet<>(directorsList);
		System.out.println("Directors worked in Ghibli films");
		set.forEach(System.out::println);
	}
}
