package Model;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Help {


    private static Locale current;
    private static ResourceBundle rb;

    private static final Logger log=Logger.getLogger(Help.class);
    {
        PropertyConfigurator.configure("log4j.properties");
    }


    public static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            log.info("User made an input in Controller:dataInput()");
            return true;
        } catch (NumberFormatException e) {
            log.error("User made wrong input in Controller:dataInput()");
            return false;
        }

    }

    private static void getLocale(){
        String choice=new String();
        Scanner sc=new Scanner(System.in);
        String country=new String();
        String language=new String();
        while(true){
            System.out.print("Choose your language: (1-english, 2-українська, 3-русский:");
            choice=sc.next();
            if(isNumber(choice)){
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
        String st=rb.getString("strTypeChoice");
//        String s1=new String();
//        try{
//            s1=new String(st.getBytes("cp1252"), "cp1251");
//        }
//        catch(Exception e){}
//        System.out.println(s1);
    }

    public static void insertTracks(){
        try{
            ArrayList<Track> arr=new ArrayList<Track>();
            arr.add(new Track(1,"Track1",Styles.ROCK,2.00));
            arr.add(new Track(2,"Track2",Styles.ROCK,3.45));
            arr.add(new Track(3,"Track3",Styles.ROCK,3.11));

            arr.add(new Track(4,"Track4",Styles.RAP,4.01));
            arr.add(new Track(5,"Track5",Styles.RAP,3.33));
            arr.add(new Track(6,"Track6",Styles.RAP,2.56));

            arr.add(new Track(7,"Track7",Styles.METAL,5.45));
            arr.add(new Track(8,"Track8",Styles.METAL,5.56));
            arr.add(new Track(9,"Track9",Styles.METAL,7.40));

            File fw = new File("File.txt");
            FileOutputStream fos = new FileOutputStream(fw);
            ObjectOutputStream ostream = new ObjectOutputStream(fos);
//            System.out.println(arr.size());
            for(int i=0;i<arr.size();i++){
//                System.out.println(arr.get(i).getTrackName());
                ostream.writeObject((arr.get(i)));
            }
            ostream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<Track> getTracks(String fileName){
        try{
            ArrayList<Track> arr=new ArrayList<Track>();

            File fr=new File(fileName);
            FileInputStream fis=new FileInputStream(fr);
            ObjectInputStream istream= new ObjectInputStream(fis);
            Object obj;
            while (true){
                //for(int i=0;i<9;i++){

                System.out.println("Reading");
//                Track t=(Track)istream.readObject();

                if(fis.available()!=0){
                    obj=istream.readObject();
                    System.out.println(((Track)obj).getTrackId()
                            +((Track)obj).getTrackName()+" "
                            +((Track)obj).getTrackStyle()+" "
                            +((Track)obj).getTrackLength());
                    arr.add((Track)obj);
                }
                else{
                    System.out.println("NULL");
                    break;
                }

//                System.out.println(arr.get(i).getTrackName()+" "+arr.get(i).getTrackStyle()+" "+arr.get(i).getTrackLength());
            }
            istream.close();
            System.out.println(arr.size());
//            for(int i=0;i<arr.size();i++){
//                System.out.println("ARR "+arr.toString());
//            }
            return arr;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public static void getLength(ArrayList<Track> arr){
        double length;
        int minutes=0;
        double seconds=0;

        for(int i=0;i<arr.size();i++){
            minutes+=(int)(arr.get(i).getTrackLength());
            seconds+=(arr.get(i).getTrackLength())%((int)(arr.get(i).getTrackLength()));
        }
        //int sec=(int)seconds*100;
        System.out.println("MIN:"+minutes+" SEC:"+seconds);
        minutes+=(int)(seconds*100/60);
        seconds=(seconds*100)%60;
        System.out.println("MIN:"+minutes+" SEC:"+seconds);

    }
}
