package sheylli.myappcompany.covid_19tracker;

public class Model {


    private String sname;
    private String dname;
    private long active;
    private long recovered;
    private long confirmed;
    private long deceased;

    public Model() {
    }

    public Model(String sname, String dname, long active, long recovered, long confirmed, long deceased) {
        this.sname = sname;
        this.dname = dname;
        this.active = active;
        this.recovered = recovered;
        this.confirmed = confirmed;
        this.deceased = deceased;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public long getDeceased() {
        return deceased;
    }

    public void setDeceased(long decreased) {
        this.deceased = deceased;
    }
}
