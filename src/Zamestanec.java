import java.time.LocalDate;

public class Zamestanec {
    private String jmeno;
    private String prijmeni;
    private boolean pojisteni;
    private LocalDate narozeni;

    public Zamestanec(String jmeno, String prijmeni, boolean pojisteni, LocalDate narozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.pojisteni = pojisteni;
        this.narozeni = narozeni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public boolean isPojisteni() {
        return pojisteni;
    }

    public void setPojisteni(boolean pojisteni) {
        this.pojisteni = pojisteni;
    }

    public LocalDate getNarozeni() {
        return narozeni;
    }

    public void setNarozeni(LocalDate narozeni) {
        this.narozeni = narozeni;
    }
}
