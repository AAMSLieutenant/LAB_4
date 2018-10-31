import Model.Help;
import Model.Styles;
import Model.Track;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Application {




    public static void main(String[] args) {
//        Track t=new Track("Слющай дарагой", Styles.ROCK,2.33);
//        t.writeTrack(t);
//        t=t.readTrack("File.txt");
//        System.out.println(t.getTrackName()+" "+t.getTrackStyle()+" "+t.getTrackLength());
        Track t=new Track();
//        Help.insertTracks();
        ArrayList<Track> arr=Help.getTracks("File.txt");
        Help.getLength(arr);
    }

}
