package mybatis.domain;

public class Sac {
    private String transcode;

    private String servicename;

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode == null ? null : transcode.trim();
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename == null ? null : servicename.trim();
    }
}