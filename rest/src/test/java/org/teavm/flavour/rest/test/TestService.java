/*
 *  Copyright 2015 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.flavour.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.teavm.flavour.rest.Resource;

@Resource
@Path("test")
public interface TestService {
    
    public static enum OP{
        PLUS, MINUS
    }
    
    @GET
    @Path("integers/sum")
    int sum(@QueryParam("a") int a, @QueryParam("b") int b);

    @GET
    @Path("integers/mod-{mod}/sum")
    int sum(@PathParam("mod") int mod, @QueryParam("a") int a, @QueryParam("b") int b);
    
    @PATCH
    @Path("integers/{val}")
    int update(@PathParam("val") int val, @QueryParam("b") int b);
    
    @GET
    @Path("integers")
    int op(@QueryParam("op") OP val, @QueryParam("a") int a, @QueryParam("b") int b);
}
