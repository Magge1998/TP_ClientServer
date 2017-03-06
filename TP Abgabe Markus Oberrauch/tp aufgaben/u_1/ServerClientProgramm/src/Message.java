import java.io.Serializable;

/*
 * Created by Markus on 01.02.17.
 */
public abstract class Message implements Serializable {

    private String input;


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
