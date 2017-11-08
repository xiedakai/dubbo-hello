package com.emep.dubbo.demo.model;

import org.codehaus.jackson.annotate.JsonProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 9147244542309069857L;

	@NotNull
	@Min(1L)
	private Long id;

	@JsonProperty("username")
	@NotNull
	@Size(min = 6, max = 50)
	private String name;

	public User() {
	}

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User (" + "id=" + id + ", name='" + name + '\'' + ')';
	}
}
