package main.compa.app;

import com.google.gson.annotations.Expose;
import javafx.util.Pair;
import main.compa.models.JSONisable;

public class Exception extends java.lang.Exception implements JSONisable {
    @Expose
    private Integer code;

    public Exception(){}

    public Exception(Pair<Integer, String> message)
    {
        super(message.getValue());
        this.code = message.getKey();
    }
}
