import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int kases = s.nextInt();
        s.nextLine();
        s.nextLine();
        
        for (int k = 0; k < kases; ++k) {
            if (k != 0) {
                System.out.println();
            }
            
            double distance = 0;
            
            s.nextLine();
            while (true) {
                if (!s.hasNext()) {
                    break;
                }
                
                String[] line = s.nextLine().split(" ");
                
                if (line.length != 4) {
                    break;
                }
                
                double x1 = Integer.parseInt(line[0]);
                double y1 = Integer.parseInt(line[1]);
                double x2 = Integer.parseInt(line[2]);
                double y2 = Integer.parseInt(line[3]);
                
                distance += Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
            }
            
            distance *= 2;
            double hour = (double)(distance / 20000);
            distance -= 20000 * (long)hour;
            double minute = (double) distance / (double) 20000 * 60;
            
            if ((int)Math.ceil(minute) == 60) {
                minute = 0;
                ++hour;
            }
            
            minute = Math.ceil(minute);
            
            System.out.println((int)hour + ":" + (minute < 10 ? "0" : "") + (int)minute);
        }
    }
}