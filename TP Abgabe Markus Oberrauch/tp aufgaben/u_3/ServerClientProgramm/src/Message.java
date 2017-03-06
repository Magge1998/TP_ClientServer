import java.io.Serializable;

/*
 * Created by Markus on 01.02.17.
 */
public abstract class Message implements Serializable {




    Integer Int_1;
    String Message;

    public String getMessage() {
        return Message;
    }

    public Integer getInt1() {
        return Int_1;
    }
    public void setInt1(Integer anInt) {
        Int_1 = anInt;
    }

    public void setMessage(String message) {
        Message = message;
    }




}




