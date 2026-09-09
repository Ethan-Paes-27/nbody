import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {

    public static void main(String[] args) {
        double totalTime = 157788000.0;
        double dt = 25000.0;
        String pfile = "data/planets.txt";
        if (args.length > 2) {
            totalTime = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            pfile = args[2];
        }

        String fname = "./data/planets.txt";

        // //Planet[] planets = readPlanets(fname);

        // double radius = 0.0;
        // readRadius(fname);


        // System.out.printf("%d\n", planets.length);
        // System.out.printf("%.2e\n", radius);
        // for (int i = 0; i < planets.length; i++) {
        //     System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        //             planets[i].xPos, planets[i].yPos,
        //             planets[i].xVel, planets[i].yVel,
        //             planets[i].mass, planets[i].fileName);
        // }

        // StdDraw.setScale(-radius, radius);
        // StdDraw.picture(0, 0, "images/starfield.jpg");

        // for (double t = 0.0; t < totalTime; t += dt) {

        // }
    }

    public static double readRadius(String fname) {
        try {
            Scanner scan = new Scanner(new File(fname));

            int numPlanets = scan.nextInt();

            double value = scan.nextDouble();

            scan.close();

            return value;
        } catch (FileNotFoundException e) {
            System.out.println("fumbled");
        }

        return 0;
    }
}

