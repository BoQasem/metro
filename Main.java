import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    static int[] getIndexComma(String line){
        int[] indexTwoComma = new int[2];  
        int itr = 0; 
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == ','){
                indexTwoComma[itr++] = i;
            }
        }

        return indexTwoComma; 
    }

    static void addNodeAndEdge(int numStation, File file, Graph obj){
        try {
            Scanner myReader = new Scanner(file);
            myReader.nextLine();
            int src = -1;
            int dst = 0;  
            while(myReader.hasNextLine()){
                src++; 
                dst++; 
                String line = myReader.nextLine(); 
                int[] indexTwoComma = getIndexComma(line); 
    
                String node = line.substring(indexTwoComma[0]+1, indexTwoComma[1]);
                obj.addStation(new Station(node));
                if(numStation != dst){
                    obj.addEdge(src, dst); 
                    obj.addEdge(dst, src); 
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        obj.presentOnFile();
    }

    public static void main(String[] args){
        
        int numStation = 35; 
        Graph obj = new Graph(numStation);
        File file = new File("data.txt");
        addNodeAndEdge(numStation,file,obj);
        
        System.out.println("Done ");    
    }
    
}