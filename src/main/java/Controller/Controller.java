package Controller;
import Model.Help;
import Model.Styles;
import Model.Track;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private static final Logger log=Logger.getLogger(Help.class);
    public static Locale current;
    public static ResourceBundle rb;


    private static String fileName="File.txt";


    static{
        PropertyConfigurator.configure("log4j.properties");
    }


    private static void getLocale(){
        String choice=new String();
        Scanner sc=new Scanner(System.in);
        String country=new String();
        String language=new String();
        while(true){
            System.out.print("Choose your language: (1-english, 2-українська, 3-русский:");
            choice=sc.next();
            if(Help.isNumber(choice)){
                int c=Integer.parseInt(choice);
                switch(c){
                    case 1:country="US";language="EN";break;
                    case 2:country="UA";language="UK";break;
                    case 3:country="RU";language="RU";break;
                }
                break;
            }
            else{
                log.error("User made mistake in choosing the language");
                System.out.println("wrong format");
            }
        }
        current=new Locale(language,country);
        rb=ResourceBundle.getBundle("text",current);
//        String st=rb.getString("strTypeChoice");
//        String s1=new String();
//        try{
//            s1=new String(st.getBytes("cp1252"), "cp1251");
//        }
//        catch(Exception e){}
//        System.out.println(s1);
    }

    private static void insertData() throws UnsupportedEncodingException {
        Scanner sc=new Scanner(System.in);
        String choice;
//        System.out.println("Insert the name of the track:");
        String str=rb.getString("strSetName");
        String res=new String(str.getBytes("cp1252"), "cp1251");
        System.out.println(res);

        choice=sc.nextLine();
        log.info("name of the track inserted");
        Help.settName(choice);


        Styles st=null;
        str=rb.getString("strSetStyle");
        res=new String(str.getBytes("cp1252"), "cp1251");
        System.out.println(res);
//        System.out.println("Choose style of the track:");
//        System.out.println("1 - rock");
//        System.out.println("2 - rap");
//        System.out.println("3 - classic");
//        System.out.println("4 - metal");
        choice = sc.nextLine();
        log.info("style of the track inserted");
        switch (Integer.parseInt(choice)) {
            case 1: st = Styles.ROCK;break;
            case 2: st = Styles.RAP;break;
            case 3: st = Styles.CLASSIC;break;
            case 4: st = Styles.METAL;break;
        }
        Help.settStyle(st);
//        System.out.println("Insert the length of the track:");
        str=rb.getString("strSetLength");
        res=new String(str.getBytes("cp1252"), "cp1251");
        System.out.println(res);
        choice=sc.nextLine();
        log.info("length of the track inserted");
        Help.settLength(Double.parseDouble(choice));

        Help.insertTrack(Help.gettName(), Help.gettStyle(), Help.gettLength());
        log.info("new track is inserted");
    }


    public static void view(){
        try {
            getLocale();



            Scanner sc = new Scanner(System.in);
            String choice = new String();
            int ch = 0;
            while (true) {
//                System.out.println("Choose the option:");
//                System.out.println("1 - create own track");
//                System.out.println("2 - read media from file");
//                System.out.println("3 - sort the playlist");
//                System.out.println("4 - search by amount");
//                System.out.println("4 - get length of the playlist");
                String str=rb.getString("strMenu");
                String res=new String(str.getBytes("cp1252"), "cp1251");
                System.out.println(res);
                choice = sc.nextLine();
                if (Help.isNumber(choice)) {
                    ch = Integer.parseInt(choice);
                    if ((ch > 0) && (ch < 6)) {
//                    break;
                        if (ch == 1) {
                            insertData();
                            log.info("insertData is started");
                        }
                        if (ch == 2) {
                            ArrayList<Track> tracks = Help.getTracks(fileName);
                            Help.printTracks(tracks);
                        }
                        if (ch == 3) {
                            Styles st = null;
                            while (true) {
//                                System.out.println("Choose style to sort by:");
//                                System.out.println("1 - rock");
//                                System.out.println("2 - rap");
//                                System.out.println("3 - classic");
//                                System.out.println("4 - metal");
                                str=rb.getString("strStyle");
                                res=new String(str.getBytes("cp1252"), "cp1251");
                                System.out.println(res);
                                choice = sc.nextLine();
                                if (Help.isNumber(choice)) {
                                    switch (Integer.parseInt(choice)) {
                                        case 1:
                                            st = Styles.ROCK;
                                            break;
                                        case 2:
                                            st = Styles.RAP;
                                            break;
                                        case 3:
                                            st = Styles.CLASSIC;
                                            break;
                                        case 4:
                                            st = Styles.METAL;
                                            break;
                                    }
                                    ArrayList<Track> tracks = Help.getTracks(fileName);
                                    Help.sort(tracks, st);
                                    log.info("sort method is chosen");
                                    break;
                                }
                            }

                        }
                        if (ch == 4) {
                            while (true) {
//                                System.out.println("Insert the length amount:");
                                str=rb.getString("strLength");
                                res=new String(str.getBytes("cp1252"), "cp1251");
                                System.out.println(res);
                                choice = sc.nextLine();
                                if (Help.isNumber(choice)) {
                                    ArrayList<Track> tracks = Help.getTracks(fileName);
                                    int am = Integer.parseInt(choice);
                                    Help.getByAmmount(tracks, am);
                                    log.info("amountSort is chosen");
                                    break;
                                }
                            }
                        }
                        if (ch == 5) {

                            System.out.println(Help.getLength(Help.getTracks("File.txt")));
                        }


                    } else {
//                        System.out.println("Wrong data insert");
                        str=rb.getString("strWrongFormat");
                        res=new String(str.getBytes("cp1252"), "cp1251");
                        System.out.println(res);
                        log.error("wrong data insert");
                    }
                } else {
//                    System.out.println("Wrong data insert");
                    str=rb.getString("strWrongFormat");
                    res=new String(str.getBytes("cp1252"), "cp1251");
                    System.out.println(res);
                    log.error("wrong data insert");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
