package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Questions_collection {
	private List<Question> Collection=new ArrayList<>();

	public List<Question> getCollection() {
		return Collection;
	}

	public void setCollection(List<Question> collection) {
		Collection = collection;
	}
	public void addIntoCollection(Question question) {
		this.Collection.add(question);
	}
}
