package pojo.appsDetails;

public class Application_env_json
{
    private VCAP_APPLICATION VCAP_APPLICATION;

    public void setVCAP_APPLICATION(VCAP_APPLICATION VCAP_APPLICATION){
        this.VCAP_APPLICATION = VCAP_APPLICATION;
    }
    public VCAP_APPLICATION getVCAP_APPLICATION(){
        return this.VCAP_APPLICATION;
    }
}
