package Model;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Help {



    private static String tName;
    private static Styles tStyle;
    private static double tLength;


    private static final Logger log=Logger.getLogger(Help.class);
    static{
        PropertyConfigurator.configure("log4j.properties");
    }

//Проверка на введенное число
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


//Получение локализации



//Изначальное наполнение медиатеки
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




    public static void printTracks(ArrayList<Track> tracks){
        for(Track t:tracks){
            System.out.println(t.getTrackId()+" "
                    +t.getTrackName()+" "
                    +t.getTrackStyle()+" "
                    +t.getTrackLength());

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

//                System.out.println("Reading");

                if(fis.available()!=0){
                    obj=istream.readObject();
//                    System.out.println(((Track)obj).getTrackId()
//                            +((Track)obj).getTrackName()+" "
//                            +((Track)obj).getTrackStyle()+" "
//                            +((Track)obj).getTrackLength());
                    arr.add((Track)obj);
                }
                else{
//                    System.out.println("NULL");
                    break;
                }
//                printTracks(arr);
//                System.out.println(arr.get(i).getTrackName()+" "+arr.get(i).getTrackStyle()+" "+arr.get(i).getTrackLength());
            }
            istream.close();
//            System.out.println(arr.size());
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


//Рассчет длины медиатеки
    public static double getLength(ArrayList<Track> arr){
        double length;
        int minutes=0;
        double seconds=0;

        for(int i=0;i<arr.size();i++){
            minutes+=(int)(arr.get(i).getTrackLength());
            seconds+=(arr.get(i).getTrackLength())%((int)(arr.get(i).getTrackLength()));
        }

//        System.out.println("MIN:"+minutes" SEC:"+seconds);
        minutes+=(int)(seconds*100/60);
        seconds=(seconds*100)%60;
        double result=minutes+seconds/100;
//        System.out.println("Overall length:\n"+"MIN:"+minutes+" SEC:"+seconds);
        return result;
    }





//Сортировка медиатеки по стилю
    public static ArrayList<Track> sort(ArrayList<Track> arr, Styles s){

        ArrayList<Track> temp=new ArrayList<Track>();

        for(Track t:arr){
            if(t.getTrackStyle()==s){
                temp.add(t);
            }
        }
        for(Track t:arr){
            if(t.getTrackStyle()!=s){
                temp.add(t);
            }
        }
        for(int i=0;i<temp.size();i++){
//            System.out.println(arr.get(i).getTrackName()+" "+arr.get(i).getTrackStyle()+" "+arr.get(i).getTrackLength());
            System.out.println(temp.get(i).getTrackId()+" "
                    +temp.get(i).getTrackName()+" "
                    +temp.get(i).getTrackStyle()+" "
                    +temp.get(i).getTrackLength());

        }
        return temp;

    }

//Получение треков по диапазону длины
    public static ArrayList<Track> getByAmmount(ArrayList<Track> arr, double lengthAmmount){
        ArrayList<Track> temp=new ArrayList<Track>();

        for(Track t:arr){
            if(t.getTrackLength()<=lengthAmmount){
                temp.add(t);
            }
        }
        if(temp.size()==0){
            System.out.println("No tracks are in this length ammount");
        }
        else {
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i).getTrackId() + " "
                        + temp.get(i).getTrackName() + " "
                        + temp.get(i).getTrackStyle() + " "
                        + temp.get(i).getTrackLength());

            }
        }
        return temp;
    }


//Ручной ввод трека
    public static void insertTrack(String tName, Styles tStyle, double tLength){
        ArrayList<Track> arr=getTracks("File.txt");
        int nextId=arr.size()+1;
        try{
            File fw = new File("File.txt");
            FileOutputStream fos = new FileOutputStream(fw);
            ObjectOutputStream ostream = new ObjectOutputStream(fos);
            arr.add(new Track(nextId,tName,tStyle,tLength));
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


    public static String gettName() {
        return tName;
    }

    public static void settName(String tName) {
        Help.tName = tName;
    }

    public static Styles gettStyle() {
        return tStyle;
    }

    public static void settStyle(Styles tStyle) {
        Help.tStyle = tStyle;
    }

    public static double gettLength() {
        return tLength;
    }

    public static void settLength(double tLength) {
        Help.tLength = tLength;
    }
}
