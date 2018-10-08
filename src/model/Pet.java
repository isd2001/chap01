package model;

import java.util.List;

public class Pet {
	String name;
	int type;
	List<String> feature;	// List 혹은 [] 을 이용해서 멀티밸류 처리도 가능
	/*
	 * source > generate setter
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setFeature(List<String> feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", feature=" + feature + "]";
	}

	
	
	
}
