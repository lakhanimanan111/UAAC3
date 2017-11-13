package pojo.appsDetails;

import java.util.List;

public class VCAP_APPLICATION
{
    private String cf_api;

    private Limits limits;

    private String application_name;

    private List<String> application_uris;

    private String name;

    private String space_name;

    private String space_id;

    private List<String> uris;

    private String users;

    private String application_id;

    private String version;

    private String application_version;

    public void setCf_api(String cf_api){
        this.cf_api = cf_api;
    }
    public String getCf_api(){
        return this.cf_api;
    }
    public void setLimits(Limits limits){
        this.limits = limits;
    }
    public Limits getLimits(){
        return this.limits;
    }
    public void setApplication_name(String application_name){
        this.application_name = application_name;
    }
    public String getApplication_name(){
        return this.application_name;
    }
    public void setApplication_uris(List<String> application_uris){
        this.application_uris = application_uris;
    }
    public List<String> getApplication_uris(){
        return this.application_uris;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSpace_name(String space_name){
        this.space_name = space_name;
    }
    public String getSpace_name(){
        return this.space_name;
    }
    public void setSpace_id(String space_id){
        this.space_id = space_id;
    }
    public String getSpace_id(){
        return this.space_id;
    }
    public void setUris(List<String> uris){
        this.uris = uris;
    }
    public List<String> getUris(){
        return this.uris;
    }
    public void setUsers(String users){
        this.users = users;
    }
    public String getUsers(){
        return this.users;
    }
    public void setApplication_id(String application_id){
        this.application_id = application_id;
    }
    public String getApplication_id(){
        return this.application_id;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return this.version;
    }
    public void setApplication_version(String application_version){
        this.application_version = application_version;
    }
    public String getApplication_version(){
        return this.application_version;
    }
}