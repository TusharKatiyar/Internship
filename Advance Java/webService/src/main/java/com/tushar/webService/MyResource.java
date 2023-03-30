package com.tushar.webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{user}")
public class MyResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("user") String user) {
        return "Hello " + user;
    }
}
