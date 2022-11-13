import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("input.txt");
        FileWriter cout = new FileWriter("output.txt");
        Scanner cin = new Scanner(fileIn);

        byte size = cin.nextByte(), counter = 1, now, index = 0;

        if(size == 1) { cout.write(String.valueOf(1)); cout.close(); return; }

        byte[] result = new byte[size];
        byte[][] matrix = new byte[size][size];
        boolean[] checked = new boolean[size];

        Queue <Byte> checking = new LinkedList<>();

        for(byte y = 0; y < size; y++){
            for(byte x = 0; x < size; x++){
                matrix[y][x] = cin.nextByte();
            }
            checked[y] = false;
        }

        while(index != -1){
            checking.add((byte) (index + 1));
            checked[index] = true;
            while(!checking.isEmpty()){
                now = checking.poll();
                result[now - 1] = counter;
                counter++;
                for(byte y = 0; y < size; y++){
                    if(!checked[y] && matrix[now - 1][y] == 1){
                        checking.add((byte) (y + 1));
                        checked[y] = true;
                    }
                }
            }
            index = -1;
            for(byte y = 0; y < size; y++){
                if(!checked[y]){
                    index = y;
                    break;
                }
            }
        }

        for(byte a : result){
            cout.write(a + " ");
        }
        cout.close();
    }
}
