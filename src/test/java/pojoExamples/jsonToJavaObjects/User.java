package pojoExamples.jsonToJavaObjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User
{
	private List<Data> data;
//	private Data simpleData;
//	public Data getSimpleData() {
//		return simpleData;
//	}
//	public void setSimpleData(Data simpleData) {
//		this.simpleData = simpleData;
//	}
	private Support support;
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public Support getSupport() {
		return support;
	}
	public void setSupport(Support support) {
		this.support = support;
	}
	
	
}
