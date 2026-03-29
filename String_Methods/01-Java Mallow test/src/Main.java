import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of labs: ");
        int numberOfLabs = scanner.nextInt();
          double[] speed = new double[numberOfLabs];
        char[] direction = new char[numberOfLabs];

        System.out.println("Enter the distance, direction and speed like this: 10km N(Direction) 30kmph");
        for (int i=0; i<numberOfLabs; i++) {
            distance[i] = scanner.nextDouble();
            direction[i] = scanner.next().charAt(0);
            speed[i] = scanner.nextDouble();
        }

        calculateTrip(numberOfLabs, distance, speed, direction);
    }

    privatedouble[] distance = new double[numberOfLabs];
       static void calculateTrip(int numberOfLabs, double[] distance, double[] speed, char[] direction) {

        findTotalDistance(distance);
        findDurationOfTrip(distance, speed, numberOfLabs);
        findDirectionTravelled(numberOfLabs, distance, direction);
    }

    private static void findDirectionTravelled(int numberOfLabs, double[] distance, char[] direction) {
        double x = 0, y = 0;
        for (int i=0; i<numberOfLabs; i++) {
            switch (direction[i]) {
                case 'N':
                    y += distance[i];
                    break;
                case 'S':
                    y -= distance[i];
                    break;
                case 'E':
                    x += distance[i];
                    break;
                case 'W':
                    x -= distance[i];
                    break;
            }
        }

        double angle = Math.toDegrees(Math.atan2(y, x));
        if (angle < 0) {
            angle += 360;
        }

        String finalDirection = getDirectionTrip(angle);
        System.out.println("Final direction from the starting point: " + finalDirection);
    }

    private static String getDirectionTrip(double angle) {
        if (angle >= 22.5 && angle < 67.5) {
            return "NE";
        } else if (angle >= 67.5 && angle < 112.5) {
            return "N";
        } else if (angle >= 112.5 && angle < 157.5) {
            return "NW";
        } else if (angle >= 157.5 && angle < 202.5) {
            return "W";
        } else if (angle >= 202.5 && angle < 247.5) {
            return "SW";
        } else if (angle >= 247.5 && angle < 292.5) {
            return "S";
        } else if (angle >= 292.5 && angle < 337.5) {
            return "SE";
        } else {
            return "E";
        }
    }

    private static void findDurationOfTrip(double[] distance, double[] speed, int numberOfLabs) {

        double totTimeTakenTrip = 0;
        int hours = 0, minutes = 0;
        for (int i=0; i<numberOfLabs; i++) {
            totTimeTakenTrip += findDuration(distance[i],speed[i]);
        }
        hours = (int) totTimeTakenTrip;
        minutes = (int) Math.round((totTimeTakenTrip - hours) * 60);
        System.out.printf("Total duration of the trip is: %d hr and %d min.\n",hours, minutes);
    }

    private static double findDuration(double distance, double speed) {
        return distance/speed;
    }

    private static void findTotalDistance(double[] distance) {

        double totDistanceTraveled = 0;
        for (double dist: distance) {
            totDistanceTraveled += dist;
        }

        System.out.println("Total Distance cover of the trip: " + totDistanceTraveled + " km.");
    }
}