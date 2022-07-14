package Lab6;

import java.util.ArrayList;

public class Visit {
    private DOB date;
    private String reason;
    private String script;
    private String note;

    private ArrayList<String> prescriptions = new ArrayList<>();

    public Visit(DOB date, String reason, String script, String note){
        this.date = date;
        this.reason = reason;
        prescriptions.add(script);
        this.note = note;
    }

    @Override
    public String toString() {
        return "Visit{" +date +reason + script +note +prescriptions +"}";
    }
}
