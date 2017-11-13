package pojo.appsDetails;

import java.util.ArrayList;
import java.util.List;

public class AppsDetail
{
    private Staging_env_json staging_env_json;

    private Running_env_json running_env_json;

    private Environment_json environment_json;

    private System_env_json system_env_json;

    private Application_env_json application_env_json;

    public void setStaging_env_json(Staging_env_json staging_env_json){
        this.staging_env_json = staging_env_json;
    }
    public Staging_env_json getStaging_env_json(){
        return this.staging_env_json;
    }
    public void setRunning_env_json(Running_env_json running_env_json){
        this.running_env_json = running_env_json;
    }
    public Running_env_json getRunning_env_json(){
        return this.running_env_json;
    }
    public void setEnvironment_json(Environment_json environment_json){
        this.environment_json = environment_json;
    }
    public Environment_json getEnvironment_json(){
        return this.environment_json;
    }
    public void setSystem_env_json(System_env_json system_env_json){
        this.system_env_json = system_env_json;
    }
    public System_env_json getSystem_env_json(){
        return this.system_env_json;
    }
    public void setApplication_env_json(Application_env_json application_env_json){
        this.application_env_json = application_env_json;
    }
    public Application_env_json getApplication_env_json(){
        return this.application_env_json;
    }
}
