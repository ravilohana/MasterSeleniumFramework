package utils;

import constants.EnvType;

import java.util.Properties;

public class ConfigLoaders {
    private final Properties properties;
    private static ConfigLoaders configLoaders;

    private ConfigLoaders(){
        String env = System.getProperty("env",String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
            case STAGE -> properties = PropertiesUtils.propertyLoader("src/test/resources/stg_config.properties");
            case PRODUCTION -> properties = PropertiesUtils.propertyLoader("src/test/resources/prod_config.properties");
            default -> throw new IllegalStateException("Invalid env type: " + env);
        }

    }

    public static ConfigLoaders getInstance(){
        if (configLoaders == null){
            configLoaders = new ConfigLoaders();
        }
        return configLoaders;
    }

    public String getBaseURL(){
        String prop = properties.getProperty("baseURL");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseURL is not specified in the stg_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("Property username is not specified in the stg_config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("Property password is not specified in the stg_config.properties file");
    }

    public String getEmailId(){
        String prop = properties.getProperty("email_id");
        if(prop != null) return prop;
        else throw new RuntimeException("Property email_id is not specified in the stg_config.properties file");
    }
}
