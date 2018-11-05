package Controller;
import Model.Help;
import Model.Styles;
import Model.Track;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static final Logger log=Logger.getLogger(Help.class);



    private static String fileName="File.txt";


    static{
        PropertyConfigurator.configure("log4j.properties");
    }


    private static void insertData(){
        Scanner sc=new Scanner(System.in);
        String choice;

        System.out.println("Insert the name of the track:");
        choice=sc.nextLine();
        Help.settName(choice);


        Styles st=null;

        System.out.println("Choose style of the track:");
        System.out.println("1 - rock");
        System.out.println("2 - rap");
        System.out.println("3 - classic");
        System.out.println("4 - metal");
        choice = sc.nextLine();

        switch (Integer.parseInt(choice)) {
            case 1: st = Styles.ROCK;break;
            case 2: st = Styles.RAP;break;
            case 3: st = Styles.CLASSIC;break;
            case 4: st = Styles.METAL;break;
        }
        Help.settStyle(st);
        System.out.println("Insert the length of the track:");
        choice=sc.nextLine();
        Help.settLength(Double.parseDouble(choice));

        Help.insertTrack(Help.gettName(), Help.gettStyle(), Help.gettLength());
    }


    public static void view(){
        Scanner sc=new Scanner(System.in);
        String choice=new String();
        int ch=0;
        while(true){
            System.out.println("Choose the option:");
            System.out.println("1 - create own track");
            System.out.println("2 - read media from file");
            System.out.println("3 - sort the playlist");
            System.out.println("4 - search by amount");
            System.out.println("4 - get length of the playlist");
            choice=sc.nextLine();
            if(Help.isNumber(choice)){
                ch=Integer.parseInt(choice);
                if((ch>0)&&(ch<6)) {
//                    break;
                    if(ch==1){
                        insertData();
                    }
                    if(ch==2){
                        ArrayList<Track> tracks = Help.getTracks(fileName);
                        Help.printTracks(tracks);
                    }
                    if(ch==3){
                        Styles st=null;
                        while(true) {
                            System.out.println("Choose style to sort by:");
                            System.out.println("1 - rock");
                            System.out.println("2 - rap");
                            System.out.println("3 - classic");
                            System.out.println("4 - metal");
                            choice = sc.nextLine();
                            if (Help.isNumber(choice)) {
                                switch (Integer.parseInt(choice)) {
                                    case 1: st = Styles.ROCK;break;
                                    case 2: st = Styles.RAP;break;
                                    case 3: st = Styles.CLASSIC;break;
                                    case 4: st = Styles.METAL;break;
                                }
                                ArrayList<Track> tracks = Help.getTracks(fileName);
                                Help.sort(tracks,st);

                                break;
                            }
                        }

                    }
                    if(ch==4){
                        while(true){
                            System.out.println("Insert the length amount:");
                            choice=sc.nextLine();
                            if(Help.isNumber(choice)){
                                ArrayList<Track> tracks=Help.getTracks(fileName);
                                int am=Integer.parseInt(choice);
                                Help.getByAmmount(tracks,am);
                                break;
                            }
                        }
                    }
                    if(ch==5){
                        System.out.println("REsult:"+Help.getLength(Help.getTracks("File.txt")));
                    }


                }
                else{
                    System.out.println("Wrong data insert");
                }
            }
            else{
                System.out.println("Wrong data insert");
            }
        }

    }
}
