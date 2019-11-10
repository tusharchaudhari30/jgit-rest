package com.tushar.dev.config;


import org.eclipse.jgit.http.server.GitServlet;
import org.eclipse.jgit.http.server.resolver.AsIsFileService;
import org.eclipse.jgit.lib.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

@Configuration
public class WebConfig {
    @Autowired
    GitProperties gitProperties;
    @Bean
    public ServletRegistrationBean<HttpServlet> countryServlet() throws IOException{

        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        GitServlet gs = new GitServlet();
        gs.setRepositoryResolver((req, name) -> {
            Repository repository=null;
            if(name.endsWith(".git")){
                name=name.substring(0,name.indexOf(".git"));
            }
            try {
                repository = gitProperties.getRepository(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return repository;
        });
        gs.setAsIsFileService(AsIsFileService.DISABLED);
        servRegBean.setServlet(gs);
        servRegBean.addUrlMappings("/git/*");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
}
