package pojo.appsDetails;

public class Limits
{
    private int fds;

    private int mem;

    private int disk;

    public void setFds(int fds){
        this.fds = fds;
    }
    public int getFds(){
        return this.fds;
    }
    public void setMem(int mem){
        this.mem = mem;
    }
    public int getMem(){
        return this.mem;
    }
    public void setDisk(int disk){
        this.disk = disk;
    }
    public int getDisk(){
        return this.disk;
    }
}