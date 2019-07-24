package com.rainish.api.provider;

import com.rainish.api.IService;
import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @Author jiajiao
 * @Date 2019/7/22 14:57
 */
@Service
@Path("/service")
public class IServiceImpl implements IService {
    @Override
    @Path("/info")
    @GET
    @Produces({"application/json"})
    public String getInfo() {
        return "dubbo test info";
    }
}
