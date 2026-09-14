import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {

    public static void main(String[] args) {
        double totalTime = 157788000.0;
        double dt = 25000.0;
        String pfile = "NBodyProject\\data\\planets.txt";
        if (args.length > 2) {
            totalTime = Double.parseDouble(args[0]);
            dt = Double.parseDouble(args[1]);
            pfile = args[2];
        }

        String fname = pfile;

        Planet[] planets = readPlanets(fname);

        double radius = 0.0;
        radius = readRadius(fname);

        System.out.printf("%d\n", planets.length);
        System.out.printf("%.2e\n", radius);
        for (Planet planet : planets) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet.xPos, planet.yPos,
                    planet.xVel, planet.yVel,
                    planet.mass, planet.fileName);
        }

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "NBodyProject\\images\\starfield.jpg");

        for (Planet planet : planets) {
            planet.draw();
        }

        for (double t = 0.0; t < totalTime; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "NBodyProject\\images\\starfield.jpg");

            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show(0);
        }

        System.out.printf("%d\n", planets.length);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xPos, planets[i].yPos,
                    planets[i].xVel, planets[i].yVel,
                    planets[i].mass, planets[i].fileName);
        }
    }

    public static double readRadius(String fname) {
        double radius = 0;

        try {
            Scanner scan = new Scanner(new File(fname));

            scan.nextInt();

            radius = scan.nextDouble();

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("fumbled");
        }

        return radius;
    }

    public static Planet[] readPlanets(String fname) {
        Planet[] planets = {};
        try {
            Scanner scan = new Scanner(new File(fname));

            int numPlanets = scan.nextInt();

            planets = new Planet[numPlanets];

            double radius = scan.nextDouble();

            for (int i = 0; i < numPlanets; i++) {
                double xPos = scan.nextDouble();
                double yPos = scan.nextDouble();
                double xVel = scan.nextDouble();
                double yVel = scan.nextDouble();
                double mass = scan.nextDouble();
                String name = scan.next();

                name = "NBodyProject\\images\\" + name;

                planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, name);
            }

            scan.close();

            return planets;

        } catch (FileNotFoundException e) {
            System.out.println("fumbled");
        }

        return new Planet[]{};
    }
}

