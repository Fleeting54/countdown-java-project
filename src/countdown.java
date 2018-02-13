import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class countdown {
    public static void main(String[] args) {

        BufferedReader br;
        FileReader fr;
        String line;
        ArrayList<String> words = new ArrayList();
        ArrayList<String> letters = new ArrayList();
        ArrayList<String> result = new ArrayList();
        ArrayList<Character> subject = new ArrayList();
        int nines=0, eights=0, sevens=0, sixes=0;


        //read in our list of words
        try{
            br = new BufferedReader(new FileReader("./resources/words.txt"));
            while((line = br.readLine())!=null){

                if(line.length()>5) {
                    words.add(line);
                }

            }

        }catch(IOException e){
            System.out.println("IOEXCEPTION YOU DUMMY");
        }

        //master loop for multi letter words
        for(int j =0; j<5;j++) {




            for (String w : words) {
                //clear list before use with next word and then
                //load word into subject list as character array
                subject.clear();
                for (int i = 0; i < w.length(); i++) {
                    subject.add(w.charAt(i));
                }

                for (String l : args) {
                    if (subject.indexOf(l.charAt(0)) >= 0) {

                        subject.remove((Character) l.charAt(0));




                        if (subject.size() == 0 && w.length()==(9-j)) {

                            result.add(w);
                        }

                    }
                }

            }
        }

        for(String s: result) {

            switch(s.length()){
                case 9: nines++;
                        break;
                case 8: eights++;
                    break;
                case 7: sevens++;
                    break;
                case 6: sixes++;
                    break;
            }


        }
        System.out.println("THERE ARE "+nines+" NINE LETTER WORDS");
        for(String s: result) {if(s.length()==9) System.out.print(" "+ s);}
        System.out.println();
        System.out.println("THERE ARE "+eights+" EIGHT LETTER WORDS");
        for(String s: result) {if(s.length()==8) System.out.print(" "+ s);}
        System.out.println();
        System.out.println("THERE ARE "+sevens+" SEVEN LETTER WORDS");
        for(String s: result) {if(s.length()==7) System.out.print(" "+ s);}
        System.out.println();
        System.out.println("THERE ARE "+sixes+" SIX LETTER WORDS");
        for(String s: result) {if(s.length()==6) System.out.print(" "+ s);}
        System.out.println();

    }
}
