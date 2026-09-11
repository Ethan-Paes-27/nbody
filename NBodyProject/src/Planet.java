public class Planet {
    final double g = 6.67 * Math.pow(10, -11);
    double xPos; // current x position
    double yPos; // current y position
    double xVel; // current velocity in x direction
    double yVel; // current velocity in y direction
    double mass; // mass of planet
    String fileName; // file name (in images folder)

    public Planet(double xp, double yp, double xv, double yv, double mass, String filename) {
        xPos = xp;
        yPos = yp;
        xVel = xv;
        yVel = yv;
        this.mass = mass;
        fileName = filename;
    }

    public Planet(Planet p) {
        xPos = p.xPos;
        yPos = p.yPos;
        xVel = p.xVel;
        yVel = p.yVel;
        mass = p.mass;
        fileName = p.fileName;
    }

    public double calcDistance(Planet p) {
        double dx = xPos - p.xPos;
        double dy = yPos - p.yPos;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        return  (mass * p.mass * g) / (Math.pow(calcDistance(p), 2));
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xPos - xPos) / (calcDistance(p));
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yPos - yPos) / (calcDistance(p));
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double net = 0;

        for (Planet p : planets) {
            if (p.equals(this)) {
                continue;
            }
            net += calcForceExertedByX(p);
        }

        return net;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double net = 0;

        for (Planet p : planets) {
            if (p.equals(this)) {
                continue;
            }
            net += calcForceExertedByY(p);
        }

        return net;
    }

    public void update(double dt, double xForce, double yForce) {
        double xAcc = xForce / mass;
        double yAcc = yForce / mass;

        xVel += dt * xAcc;
        yVel += dt * yAcc;

        xPos += dt * xVel;
        yPos += dt * yVel;
    }

    public void draw() {
        StdDraw.picture(xPos, yPos, "images/"+fileName);
    }
}
