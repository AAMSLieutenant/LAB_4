import Controller.Controller;
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

        final Logger log=Logger.getLogger(Help.class);

        PropertyConfigurator.configure("log4j.properties");
        log.info("Application started");
//        Track t=new Track("Слющай дарагой", Styles.ROCK,2.33);
//        t.writeTrack(t);
//        t=t.readTrack("File.txt");
//        System.out.println(t.getTrackName()+" "+t.getTrackStyle()+" "+t.getTrackLength());

//        Help.insertTracks();
//        ArrayList<Track> arr=Help.getTracks("File.txt");
//        System.out.println("___________________");
//        Help.sort(arr,Styles.RAP);
//        System.out.println("___________________");
//        Help.getLength(arr);
//        System.out.println("___________________");
//        Help.isertTrack("perName",Styles.CLASSIC,5.54);
//        System.out.println("___________________");
//        arr=Help.getTracks("File.txt");
//        System.out.println("___________________");
//        Help.getLength(arr);
//        System.out.println("___________________");
//        Help.sort(arr,Styles.CLASSIC);
//        System.out.println("___________________");
//        Help.getByAmmount(arr,5);
        Controller.view();
    }

}
