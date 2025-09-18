// Base Class
public class HealthTracker {
    private String type;

    public HealthTracker(String type) {
        this.type = type;
    }

    public void displayInfo() {
        System.out.println("Tracking " + this.type + " data.");
    }

    public void recordData() {
        System.out.println("Recording general health data.");
    }
}

// Intermediate Classes
public class ActivityTracker extends HealthTracker {
    public ActivityTracker(String type) {
        super(type);
    }

    @Override
    public void recordData() {
        System.out.println("Recording physical activity data.");
    }
}

public class NutritionTracker extends HealthTracker {
    public NutritionTracker(String type) {
        super(type);
    }

    @Override
    public void recordData() {
        System.out.println("Recording nutritional intake data.");
    }
}

public class SleepTracker extends HealthTracker {
    public SleepTracker(String type) {
        super(type);
    }

    @Override
    public void recordData() {
        System.out.println("Recording sleep pattern data.");
    }
}

// Subclasses of ActivityTracker
public class StepCounter extends ActivityTracker {
    public StepCounter() {
        super("Steps");
    }
}

public class DistanceTracker extends ActivityTracker {
    public DistanceTracker() {
        super("Distance");
    }
}

public class CalorieCounter extends ActivityTracker {
    public CalorieCounter() {
        super("Calories");
    }
}

// Subclasses of NutritionTracker
public class FoodEntry extends NutritionTracker {
    public FoodEntry() {
        super("Food");
    }
}

public class WaterIntake extends NutritionTracker {
    public WaterIntake() {
        super("Water");
    }
}

// Subclasses of SleepTracker
public class SleepCycle extends SleepTracker {
    public SleepCycle() {
        super("Sleep Cycle");
    }
}

public class WakeUpTime extends SleepTracker {
    public WakeUpTime() {
        super("Wake-Up Time");
    }
}