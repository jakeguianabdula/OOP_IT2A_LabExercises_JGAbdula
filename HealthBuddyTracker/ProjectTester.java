public class ProjectTester {
    public static void main(String[] args) {
        // Activity Trackers
        HealthTracker steps = new StepCounter();
        HealthTracker distance = new DistanceTracker();
        HealthTracker calories = new CalorieCounter();

        // Nutrition Trackers
        HealthTracker food = new FoodEntry();
        HealthTracker water = new WaterIntake();

        // Sleep Trackers
        HealthTracker sleepCycle = new SleepCycle();
        HealthTracker wakeUp = new WakeUpTime();

        // Array of all trackers
        HealthTracker[] trackers = {
            steps, distance, calories,
            food, water,
            sleepCycle, wakeUp
        };

        // Display info and record data for each
        for (HealthTracker t : trackers) {
            t.displayInfo();
            t.recordData();
            System.out.println("-------------------");
        }
    }
}
