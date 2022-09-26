import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Graph{
    ArrayList<Station> stations;
    int[][] matrix; 
    
    Graph(int size){
        matrix = new int[size][size]; 
        stations = new ArrayList<>(size); 
    }

    void addStation(Station node){
        stations.add(node); 
    }

    void addEdge(int src, int dst){
        matrix[src][dst] = 1; 
    }

    void presentOnFile() {
        try {
            FileWriter objWriter = new FileWriter("output.txt"); 
            for(int i=0; i<stations.size(); i++) {
                objWriter.write(stations.get(i).name + " ");
            }
            objWriter.write("\n");
            
            for(int i = 0; i < matrix.length; i++) {
                //objWriter.write(stations.get(i).name + "                    ");
                for(int j = 0; j < matrix[i].length; j++) {
                    objWriter.write(matrix[i][j] + " ");
                }
                objWriter.write("\n");
            } 
            objWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    

}    