package com.example.javabasedemo.config;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author 86187
 * Apollo动态刷新 @ConfigurationProperties 注入的bean属性值
 */
@Configuration
public class SpringBootApolloRefreshConfig {

    @Resource
    private RefreshScope refreshScope;

    private static final Logger logger = LoggerFactory.getLogger(SpringBootApolloRefreshConfig.class);

    @ApolloConfigChangeListener(value = "${listeners}", interestedKeyPrefixes = {"user."})
    public void onChange(ConfigChangeEvent changeEvent) {
        logger.info("Changes for namespace {} ", changeEvent.getNamespace());
        for(String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            logger.info("Found change - key: {}, , oldValue: {}, newValue: {}, changeType: {}", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
        }
        // 刷新所有的bean
        refreshScope.refreshAll();
    }
}
