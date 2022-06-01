package pojoExamples.jsonToJavaObjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GhibliFilms {
	private String id;
	private String title;
	
	@JsonProperty("original_title")
	private String originalTitle;
	private String description;
	private String director;
	private String producer;
	
	@JsonProperty("release_date")
	private int releaseDate;
	
	@JsonProperty("running_time")
	private int runningTime;
	
	@JsonProperty("rt_score")
	private int rtScore;
	private String url;
	private List<String> vehicles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public int getRtScore() {
		return rtScore;
	}
	public void setRtScore(int rtScore) {
		this.rtScore = rtScore;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
