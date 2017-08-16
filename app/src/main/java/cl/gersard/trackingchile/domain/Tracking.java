package cl.gersard.trackingchile.domain;

import java.util.Date;

/**
 * Created by criga on 15/08/2017.
 */

public class Tracking {

    String name;
    String code;
    String date;

    public Tracking(String name, String code, String date) {
        this.name = name;
        this.code = code;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
