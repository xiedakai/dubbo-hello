package com.emep.dubbo.demo.service;

import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.emep.dubbo.demo.model.User;

@Path("users")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public interface UserService {
	
	@GET
	@Path("{id : \\d+}")
	User getUser(
			@Min(value = 1L, message = "User ID must be greater than 1") @PathParam("id")Long id);

	@GET
	@Path("userId")
	String getUsers();
	
}