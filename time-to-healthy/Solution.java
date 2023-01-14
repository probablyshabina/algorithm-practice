import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static int floors = 0;
    static int cubicles = 0;
    static Boolean[][] passedCube;
    static HashMap<Integer, String> paths = new HashMap<>();
    static int maxPoints = 0;
    
    public static void main(String[] args){

        InputStreamReader io = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(io);

        try {
            String line1 = br.readLine();
            floors = Integer.parseInt(String.valueOf(line1.toCharArray()[0]));
            cubicles = Integer.parseInt(String.valueOf(line1.toCharArray()[2]));
            passedCube = new Boolean[floors][cubicles];
            
            for(int f = 0; f < floors; f++){
                for(int c = 0; c < cubicles; c++){
                    passedCube[f][c] = false;
                }
            }

            if(floors > 2 && cubicles < 100){
                char[][] floorplan = new char[floors][cubicles];
                int[][] start = new int[1][2];
                int[][] end = new int[1][2];

                for (int i = 0; i < floors; i++) {
                    String inpt = br.readLine();
                    floorplan[i] = inpt.toCharArray();
                    
                    if(inpt.toUpperCase().contains("S")){
                        start[0][0] = i;
                        start[0][1] = inpt.indexOf('S');
                    }
    
                    if(inpt.toUpperCase().contains("E")){
                        end[0][0] = i;
                        end[0][1] = inpt.indexOf('E');
                    }
                }   
                             
                moveNext(start[0][0], (start[0][1]), end, floorplan);

                System.out.println(maxPoints);
                //System.out.println("maxPoints : " + maxPoints);
                //System.out.println("maxPoints path : " + paths.get(maxPoints));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void moveNext(int curFloor, int curCube, int[][] end, char[][] floorplan){
        //move up
        if(curFloor + 1 < floors){//whether the current floor is the top 
            if(isNextAvailable((curFloor + 1), curCube, end, floorplan)){
                moveNext((curFloor + 1), curCube, end, floorplan);
            }
            else{
                for (Map.Entry<Integer, String> path : paths.entrySet()) {
                    if(maxPoints < path.getKey())
                        maxPoints = path.getKey();
                }
            }
        }

        //move right
        if(curCube + 1 < cubicles){//whether the current cube is the right corner 
            if(isNextAvailable(curFloor, (curCube + 1), end, floorplan)){
                moveNext(curFloor, (curCube + 1), end, floorplan);
            }
            else{
                for (Map.Entry<Integer, String> path : paths.entrySet()) {
                    if(maxPoints < path.getKey())
                        maxPoints = path.getKey();
                }
            }
        }

        //move left
        if(curCube - 1 > -1){
            if(isNextAvailable(curFloor, (curCube - 1), end, floorplan)){
                moveNext(curFloor, (curCube - 1), end, floorplan);
            }
            else{
                for (Map.Entry<Integer, String> path : paths.entrySet()) {
                    if(maxPoints < path.getKey())
                        maxPoints = path.getKey();
                }
            }
        }
        passedCube[curFloor][curCube] = false;
    }

    static boolean isNextAvailable(int curFloor, int curCube, int[][] end, char[][] floorplan){
        if(!passedCube[curFloor][curCube]){//must not be prevously passed cube
            if(!(String.valueOf(floorplan[curFloor][curCube]).equalsIgnoreCase("s")) &&
                    floorplan[curFloor][curCube] != '#')
            { //must not be unmovable cube or the start cube
                if(end[0][0] == curFloor && end[0][1] == curCube ){//if end cube
                    
                    String path = "";
                    int points = 0;
                    for(int f = 0; f < floors; f++){
                        for(int c = 0; c < cubicles; c++){
                            if(passedCube[f][c]){
                                path += String.valueOf(f) + c + ",";
                                points += Integer.parseInt(String.valueOf(floorplan[f][c]));
                            }
                        }
                    }

                    boolean isAvailable = false;
                    for (Map.Entry<Integer, String> pathh : paths.entrySet()) {
                        if(pathh.getValue().equalsIgnoreCase(path)){
                            isAvailable = true;
                            break;
                        }
                    }

                    if(!(isAvailable))
                        paths.put(points, path);
                    
                    return false;
                }
                else{//must not be the end cube
                    passedCube[curFloor][curCube] = true;
                    return true;
                }
                
            }
        }
        return false;
    }
}
