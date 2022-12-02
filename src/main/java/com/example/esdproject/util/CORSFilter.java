package com.example.esdproject.util;


import jakarta.ws.rs.container.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

// This class adds the CORS policy for the backend server to each Response being sent
// Much thanks to this StackOverflow post for this great explanation
// https://stackoverflow.com/questions/28065963/how-to-handle-cors-using-jax-rs-with-jersey

@Provider
@PreMatching
public class CORSFilter implements ContainerRequestFilter, ContainerResponseFilter {

    // Method for ContainerRequestFilter
    @Override
    public void filter(ContainerRequestContext request) throws IOException {

        // If it's a preflight request, we abort the request with a 200 status,
        // and the CORS headers are added in the response filter method below.
        if (isPreflightRequest(request))
            request.abortWith(Response.ok().build());
    }

    // A preflight request is an OPTIONS request with an Origin header.
    private static boolean isPreflightRequest(ContainerRequestContext request) {
        return request.getHeaderString("Origin") != null
                && request.getMethod().equalsIgnoreCase("OPTIONS");
    }

    // Method for ContainerResponseFilter
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response)
            throws IOException {

        // If there is no Origin header, then it is not a cross-origin request. We don't do anything.
        if (request.getHeaderString("Origin") == null) {
            return;
        }

        // If it is a preflight request, then we add all the CORS headers here.
        if (isPreflightRequest(request)) {
            response.
                    getHeaders().
                    add("Access-Control-Allow-Credentials", "true");
            response.
                    getHeaders().
                    add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.getHeaders().
                    add("Access-Control-Allow-Headers",
                            // Whatever other non-standard/safe headers (see list above)
                            // you want the client to be able to send to the server,
                            // put it in this list. And remove the ones you don't want.
                            "X-Requested-With, Authorization, Accept-Version, Content-MD5, CSRF-Token, Content-Type");
        }

        // Cross-origin requests can be either simple requests or preflight request.
        // We need to add this header to both type of requests.
        // Only preflight requests need the previously added headers.
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
    }
}
