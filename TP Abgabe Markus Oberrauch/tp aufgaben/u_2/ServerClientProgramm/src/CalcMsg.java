import java.io.Serializable;

/**
 * Created by Markus on 14.02.17.
 */
public class CalcMsg extends Message {



    private String zahl1;
    private String zahl2;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    private String uName;


    public String getZahl1() {
        return zahl1;
    }

    public void setZahl1(String zahl1) {
        this.zahl1 = zahl1;
    }

    public String getZahl2() {
        return zahl2;
    }

    public void setZahl2(String zahl2) {
        this.zahl2 = zahl2;
    }


}
