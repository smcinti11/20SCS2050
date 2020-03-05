import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class CarWashSimulation {

    private static final int    MIN_TIME_WASH = 5;  // minutes
    private static final int    MAX_TIME_WASH = 15;  // minutes
    private static final int    CHANCE_NEW_CAR = 50; // 1-100% chance
    private static final String DATA_FILENAME = "cars.csv";
    private static String[] data = null;

    public static void loadData() {
        try {
            Scanner in = new Scanner(new FileInputStream(DATA_FILENAME));
            // 1st line has the number of cars
            int total = Integer.parseInt(in.nextLine());
            data = new String[total];
            int i = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                data[i++] = line;
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Car getRandomCar() {
        Random r = new Random();
        int i = r.nextInt(data.length);
        String fields[] = data[i].split(",");
        return new Car(fields[0], fields[1], Integer.parseInt(fields[2]));
    }

    public static void run(int minutes) {
        DynamicQueue<Car> queue = new DynamicQueue<>();
        Random r = new Random();
        Car car = null; // this points to the car being washed
        int timer = 0; // counts the minutes to wash the car
        System.out.println("Simulation starts now for " + minutes + " minutes!");
        for (int i = 0; i < minutes; i++) {
            String padded = String.format("%03d" , i);
            System.out.print(padded + ". ");
            System.out.print(queue);
            if (car != null)
                System.out.print(" being washed: " + car);
            System.out.println();
            // TODOd: simulate that a new car arrived using CHANCE_NEW_CAR
            if (r.nextInt(100) + 1 <= CHANCE_NEW_CAR)
                queue.push(getRandomCar());

            // TODOd: if no cars is being washed, get the next car to be served from the queue
            if (car == null && !queue.isEmpty()) {
                car = queue.pop();
                timer = r.nextInt(MAX_TIME_WASH - MIN_TIME_WASH + 1) + MIN_TIME_WASH;
            }

            // TODOd: if a car is currently being served, decrease the timer and finish servicing the car if timer reaches 0
            if (car != null) {
                timer--;
                if (timer == 0)
                    car = null;
            }

        }
        System.out.println("Simulation completed!");
    }

    public static void main(String[] args) {
        loadData();
        run(100);
    }
}
