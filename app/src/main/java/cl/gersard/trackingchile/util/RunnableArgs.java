package cl.gersard.trackingchile.util;


import cl.gersard.trackingchile.domain.Track;

public class RunnableArgs implements Runnable {

    private int response;
    private Track track;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public void run() {
        // do whatever you want with data
    }
}
