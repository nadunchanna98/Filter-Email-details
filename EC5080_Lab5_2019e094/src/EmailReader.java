/*********     2019E094  ***********/
/*********    PERERA G.A.N.C.   ***********/
/*** I certify the code of this lab is entirely  ***/

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.*;


public class EmailReader {

    public static String[] lines ;



    public static String printName(int index,int val,String who){
        String Name1 = filter(lines[index],val);
        String Name2 = filter(lines[index],val+1);
        System.out.println(who+" name : "+Name1+" "+Name2);
        return Name1+" "+Name2;
    }

    public static String printEmail(int index,int val,String who){

        String email = filter(lines[index],val+2);
        System.out.println(who+" Email :"+ RegulareCheckEmail(email));
        return RegulareCheckEmail(email);
    }

    public static String[] reader(String path ) throws Exception {

        File file = new File(path);

            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String line;
            String[] lines = new String[100];

            int i = 0;
            int j = 0;

            while ((line = in.readLine()) != null)
            {
                if(line != null){j++;}
                lines[i] = line;
                i++;
            }
        String[] lines2 = new String[j+1];

            for(int a=0;a<j ;a++){
                lines2[a]=lines[a];
            }

            System.out.println("\n\tUnfiltered Email massage : \n");
        for(String e: lines2)
        {
                if(e == null){break;}
                System.out.println(e);
        }
        System.out.println("\n");
            return lines2;

    }

    public static String filter(String line,int val){

        String[] strArray = null;
        strArray = line.split(" ");
        return strArray[val];


}

    public static String filterSubjectAndLab(){

        String[] strArray = new String[3];

        String userInput = "[0-9]+";
        Pattern P = Pattern.compile(userInput);
        Matcher M = P.matcher(lines[4]);

        int i = 0 ;
        while (M.find()) {
            strArray[i] = M.group();
            i++;
        }
     System.out.println("Subject : EC"+strArray[0] );
        System.out.println("Lab : LAB"+strArray[1] );

        return  "EC"+strArray[0] +"  LAB"+strArray[1];

    }

    public static String RegulareCheckEmail(String email) {

        String userInput2 = "";

        try {

                String userInput = "[^<>]+";
                Pattern P = Pattern.compile(userInput);
                Matcher M = P.matcher(email);

                while (M.find()) {
                    userInput2 = M.group();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInput2;
    }

    public static String Date(){

        String date = filter(lines[1],1)+" "+filter(lines[1],2)+
                " "+filter(lines[1],3)+" "+filter(lines[1],4);
        System.out.println("Date : "+date);

        return date;
    }

    public static String Time(){

        String time = filter(lines[1],5);
        System.out.println("Time : "+time);
        return time;

    }

    public  static void BufferedWriterExample(String Line){

        FileWriter writer = null;
        try {
            writer = new FileWriter("G:\\academic\\sem 5\\EC5080 Software Construction\\labs\\EC5080_Lab5_2019e094\\emailsList.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter buffer = new BufferedWriter(writer);


        try {
            buffer.write(Line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nSuccess saving details in File");

    }



    public static void main(String[] args) throws Exception {

        String path = "G:\\academic\\sem 5\\EC5080 Software Construction\\labs\\EC5080_Lab5_2019e094\\emailFile.txt";
        lines = reader(path);

        System.out.println("\tfiltered Email massage : \n");
        //Sender Name and Email
        String SenderName =  printName(0,1,"Sender");
        String SenderEmail = printEmail(0,1,"Sender");

        //Receiver Name and Email
        String ReceiverName = printName(2,1,"Receiver");
        String ReceiverEmail = printEmail(2,1,"Receiver");

        String date =Date();
        String time  =Time();
       String SubjectAndLab =  filterSubjectAndLab();

        FileWriter writer = new FileWriter("G:\\academic\\sem 5\\EC5080 Software Construction\\labs\\EC5080_Lab5_2019e094\\emailsList.txt");
        BufferedWriter buffer = new BufferedWriter(writer);

        BufferedWriterExample("Sender Name : "+SenderName+"\nSender Email : "+SenderEmail
                +"\nReceiver Name : "+ReceiverName+"\nReceiver Email : "+ReceiverEmail+"\nDate : "+date
                +"\nTime : "+time+"\nSubject And Lab : "+SubjectAndLab);

    }


}
