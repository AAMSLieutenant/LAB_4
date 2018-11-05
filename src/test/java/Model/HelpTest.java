package Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HelpTest {

    @Test
    void getTracks() {
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

        assertEquals(arr,Help.getTracks("File.txt"));
    }

    @Test
    void getLength() {
        assertEquals(38.47,Help.getLength(Help.getTracks("File.txt")));
    }

    @Test
    void sort() {
        ArrayList<Track> expArr=new ArrayList<Track>();
        expArr.add(new Track(4,"Track4",Styles.RAP,4.01));
        expArr.add(new Track(5,"Track5",Styles.RAP,3.33));
        expArr.add(new Track(6,"Track6",Styles.RAP,2.56));
        expArr.add(new Track(1,"Track1",Styles.ROCK,2.00));
        expArr.add(new Track(2,"Track2",Styles.ROCK,3.45));
        expArr.add(new Track(3,"Track3",Styles.ROCK,3.11));
        expArr.add(new Track(7,"Track7",Styles.METAL,5.45));
        expArr.add(new Track(8,"Track8",Styles.METAL,5.56));
        expArr.add(new Track(9,"Track9",Styles.METAL,7.40));



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





        assertEquals(expArr, Help.sort(arr,Styles.RAP));
    }

    @Test
    void getByAmmount() {
        ArrayList<Track> expArr=new ArrayList<Track>();
        expArr.add(new Track(1,"Track1",Styles.ROCK,2.00));
        expArr.add(new Track(6,"Track6",Styles.RAP,2.56));

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
        assertEquals(expArr, Help.getByAmmount(arr,3));
    }


}