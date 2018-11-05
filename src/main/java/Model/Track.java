package Model;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Track implements Serializable{




    private int trackId;

    private String trackName;

    public double getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(double trackLength) {
        this.trackLength = trackLength;
    }

    private double trackLength;

    public Styles getTrackStyle() {
        return trackStyle;
    }

    public void setTrackStyle(Styles trackStyle) {
        this.trackStyle = trackStyle;
    }

    private Styles trackStyle;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }


    public Track(){

    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }


    public Track(int trackId, String trackName, Styles trackStyle, double trackLength){
        this.trackId=trackId;
        this.trackName=trackName;
        this.trackStyle=trackStyle;
        this.trackLength=trackLength;
    }

    public void writeTrack(Track t) {
        try {
            File fw = new File("File.txt");
            FileOutputStream fos = new FileOutputStream(fw);
            ObjectOutputStream ostream = new ObjectOutputStream(fos);
            ostream.writeObject(t);
            ostream.close();
        } catch (Exception e) {

        }
    }
        public Track readTrack(String fileName){
            try{
                File fr=new File(fileName);
                FileInputStream fis=new FileInputStream(fr);
                ObjectInputStream istream= new ObjectInputStream(fis);
                Track t= (Track)istream.readObject();
                istream.close();
                return t;
            }
            catch(Exception e){

            }
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return getTrackId() == track.getTrackId() &&
                Double.compare(track.getTrackLength(), getTrackLength()) == 0 &&
                Objects.equals(getTrackName(), track.getTrackName()) &&
                getTrackStyle() == track.getTrackStyle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrackId(), getTrackName(), getTrackLength(), getTrackStyle());
    }
}
