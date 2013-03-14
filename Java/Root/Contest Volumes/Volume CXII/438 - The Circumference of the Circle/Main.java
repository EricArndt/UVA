import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while (s.hasNext()) {
            double x1 = s.nextDouble();
            double y1 = s.nextDouble();
            double x2 = s.nextDouble();
            double y2 = s.nextDouble();
            double x3 = s.nextDouble();
            double y3 = s.nextDouble();

            double ab = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            double bc = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
            double ca = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
            /*
            double area = 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1);

            double radius = ab * bc * ca / (4 * area);
            */
            
            double radius = (ab * bc * ca) / Math.sqrt((ab + bc + ca) * (bc + ca - ab) * (ca + ab - bc) * (ab + bc - ca));
            System.out.printf("%.2f\n", 2 * radius * 3.141592653589793);
        }
    }
}