import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("input.txt");
        FileWriter cout = new FileWriter("output.txt");
        Scanner cin = new Scanner(fileIn);

        byte size = cin.nextByte(), counter = 2, index = 0;
        boolean indicator = false, allChecked = false;

        if(size == 1) { cout.write(String.valueOf(1)); cout.close(); return; }

        byte[] result = new byte[size];
        boolean[] checked = new boolean[size];
        byte[][] matrix = new byte[size][size];

        for(byte y = 0; y < size; y++){
            for(byte x = 0; x < size; x++){
                matrix[y][x] = cin.nextByte();
            }
            checked[y] = false;
            result[y] = -1;
        }

        while(!allChecked) {
            if(index == 0) {
                for (byte y = 0; y < size; y++) {
                    for (byte x = 0; x < size; x++) {
                        if (matrix[y][x] != 0) {
                            checked[x] = true;
                            result[x] = counter;
                            counter++;
                            indicator = true;
                        }
                    }
                    if (indicator) {
                        checked[y] = true;
                        result[y] = 1;
                        break;
                    }
                }
            }
            else {
                for (byte y = 0; y < size; y++) {
                    for (byte x = 0; x < size; x++) {
                        if (matrix[y][x] != 0) {
                            if(!checked[y]) {
                                checked[y] = true;
                                result[y] = counter;
                                counter++;
                            }
                            if(!checked[x]){
                                checked[x] = true;
                                result[x] = counter;
                                counter++;
                                indicator = true;
                            }
                        }
                    }
                    if (indicator) {
                        break;
                    }
                }
            }

            for(byte i = 0; i < checked.length; i++){
                if(!checked[i]) break;
                else if(i == checked.length - 1) allChecked = true;
            }

            indicator = false;
            index = 1;
        }

        for(byte element : result){
            cout.write(element + " ");
        }

        cout.close();
    }
}
