package mybatis.domain;

public class Tstrfv2 {
    private String transcode;

    private String transname;

    public String getTranscode() {
        return transcode;
    }

    public void setTranscode(String transcode) {
        this.transcode = transcode == null ? null : transcode.trim();
    }

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname == null ? null : transname.trim();
    }
}