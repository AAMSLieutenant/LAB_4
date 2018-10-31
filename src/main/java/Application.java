import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Application {

    private static Locale current;
    private static ResourceBundle rb;

    private static final Logger log=Logger.getLogger(Application.class);
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


    public static void main(String[] args) {

    }

}
