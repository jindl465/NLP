import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try{
        	Scanner scan = new Scanner(System.in);
        	System.out.println("Enter the path (ex.C:\\Users\\Jin\\Desktop\\IR\\scripts)");
        	String path = scan.nextLine();
        	System.out.println("Enter the filename (ex.ZOOTOPIA.txt)");
        	String filename = scan.nextLine();
        	String filepath = path+"//"+filename;
        	scan.close();
        	
            File file = new File(filepath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<Integer> arrayListcount = new ArrayList<Integer>();

            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split("\n|\r|\"|\'|\\.|\\,|\\?|\\!|\\;|\\:|\\+|\\<|\\>"
                		+ "|\\&|\\@|\\$|\\%|\\^|\\*|\\-|\\#|\\(|\\)|\\[|\\]|\\=|\\/|\\t+|\\s+|\\d+");
                for(String tmp : words){
                    if(!tmp.equals("")){
                        if(tmp.charAt(0) >= 65 && tmp.charAt(0) <= 90 ){
                            tmp = tmp.toLowerCase();
                        }
                        if(!arrayList.contains(tmp)){
                            arrayList.add(tmp);
                            arrayListcount.add(1);
                        }
                        else{
                            int j = arrayList.indexOf(tmp);
                            arrayListcount.set(j,arrayListcount.get(j)+1);
                        }
                    }
                }
            }
            bufferedReader.close();

            try{
            	String path2 = path.replaceAll("scripts", "inverted_index");
            	String filename2 = filename.replaceAll("txt", "csv");
            	String savepath = path2 + "\\" + filename2;
            	
            	File file2 = new File(savepath);
            	if(!file2.exists()) {
            		BufferedWriter fw = new BufferedWriter(new FileWriter(savepath,true));
                    
                    fw.write("text"+","+"count");
                    fw.newLine();

                    for(int i=0;i<arrayList.size();i++){
                        fw.write(arrayList.get(i)+","+arrayListcount.get(i));
                        fw.newLine();
                    }
                    fw.flush();
                    fw.close();
            	}
        
            }
            catch (Exception e){
                e.printStackTrace();
            }

        } catch (FileNotFoundException e){
        	System.out.println("No file found");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}