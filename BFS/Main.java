import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("input.txt");
        FileWriter cout = new FileWriter("output.txt");
        Scanner cin = new Scanner(fileIn);

        byte size = cin.nextByte(), counter = 2, now;
        boolean indicator = false;

        if(size == 1) { cout.write(String.valueOf(1)); cout.close(); return; }

        byte[] result = new byte[size];
        boolean[] checked = new boolean[size];
        byte[][] matrix = new byte[size][size];

        Queue <Byte> checking = new LinkedList<>();
        Queue <Byte> newChecking = new LinkedList<>();

        for(byte y = 0; y < size; y++){
            for(byte x = 0; x < size; x++){
                matrix[y][x] = cin.nextByte();
            }
            checked[y] = false;
            result[y] = -1;
        }

        for(byte y = 0; y < size; y++){
            for(byte x = 0; x < size; x++){
                if(matrix[y][x] != 0){
                    checked[x] = true;
                    checking.add(x);
                    result[x] = counter;
                    counter++;
                    indicator = true;
                }
            }
            if(indicator){
                checked[y] = true;
                result[y] = 1;
                break;
            }
        }

        while(!checking.isEmpty()){
            while(!checking.isEmpty()){
                now = checking.poll();
                for(byte x = 0; x < size; x++){
                    if(matrix[now][x] != 0 && !checked[x]){
                        checked[x] = true;
                        newChecking.add(x);
                        result[x] = counter;
                        counter++;
                    }
                }
            }
            while(!newChecking.isEmpty()) checking.add(newChecking.poll());
        }

        for(byte x = 0; x < size; x++){
            if(!checked[x]){
                result[x] = counter;
                counter++;
                checked[x] = true;
            }
        }

        for(byte element : result){
            cout.write(element + " ");
        }

        cout.close();
    }
}
