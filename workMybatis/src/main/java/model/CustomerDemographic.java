package model;

public class CustomerDemographic {
    private String customertypeid;

    private String customerdesc;

    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid == null ? null : customertypeid.trim();
    }

    public String getCustomerdesc() {
        return customerdesc;
    }

    public void setCustomerdesc(String customerdesc) {
        this.customerdesc = customerdesc == null ? null : customerdesc.trim();
    }
}