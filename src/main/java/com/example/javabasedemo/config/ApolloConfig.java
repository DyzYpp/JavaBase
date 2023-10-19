package com.example.javabasedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 86187
 */
//@Configuration
public class ApolloConfig {

    @Value("${app.id}")
    private String appId;

    @Value("${apollo.cluster}")
    private String cluster;

    @Value("${apollo.namespaces}")
    private String namespaceName;

    @Value("${apollo.meta}")
    private String apolloMeta;

    @Bean
    public ApolloConfig apolloConfig() {
        ApolloConfig apolloConfig = new ApolloConfig();
        apolloConfig.setAppId(appId);
        apolloConfig.setNamespaceName(namespaceName);
        apolloConfig.setApolloMeta(apolloMeta);
        apolloConfig.setCluster(cluster);
        return apolloConfig;
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getNamespaceName() {
        return namespaceName;
    }

    public void setNamespaceName(String namespaceName) {
        this.namespaceName = namespaceName;
    }

    public String getApolloMeta() {
        return apolloMeta;
    }

    public void setApolloMeta(String apolloMeta) {
        this.apolloMeta = apolloMeta;
    }
}
