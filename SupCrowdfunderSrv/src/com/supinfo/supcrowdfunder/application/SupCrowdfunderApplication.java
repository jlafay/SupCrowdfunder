package com.supinfo.supcrowdfunder.application;

import com.sun.jersey.api.core.PackagesResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/resources")
public class SupCrowdfunderApplication extends PackagesResourceConfig {

    public SupCrowdfunderApplication() {
        super("com.supinfo.supcrowdfunder.resources");
    }
}
