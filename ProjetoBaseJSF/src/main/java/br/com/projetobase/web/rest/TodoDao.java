package br.com.projetobase.web.rest;

import java.util.HashMap;
import java.util.Map;

public enum TodoDao {
	instance;

	private Map<String, MyTodo> contentProvider = new HashMap<>();

	private TodoDao() {

		MyTodo todo = new MyTodo("1", "Learn REST");
		todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
		contentProvider.put("1", todo);
		todo = new MyTodo("2", "Do something");
		todo.setDescription("Read complete http://www.vogella.com");
		contentProvider.put("2", todo);

	}

	public Map<String, MyTodo> getModel() {
		return contentProvider;
	}

}
