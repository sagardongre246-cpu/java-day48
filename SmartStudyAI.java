import java.util.*;

class Subject {
    String name;
    int difficulty;   // 1 to 10
    int duration;     // in minutes

    public Subject(String name, int difficulty, int duration) {
        this.name = name;
        this.difficulty = difficulty;
        this.duration = duration;
    }
}

class CognitiveOptimizer {

    private int mentalEnergy = 100;   // starts full
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(String name, int difficulty, int duration) {
        subjects.add(new Subject(name, difficulty, duration));
    }

    public void optimizeSchedule() {
        // Sort by difficulty (hardest first)
        subjects.sort((a, b) -> b.difficulty - a.difficulty);

        System.out.println("\n📚 Optimized Study Plan:\n");

        for (Subject s : subjects) {

            int energyCost = s.difficulty * (s.duration / 10);

            if (mentalEnergy - energyCost <= 20) {
                takeBreak();
            }

            study(s, energyCost);
        }

        System.out.println("\n✅ Study Session Completed!");
    }

    private void study(Subject s, int energyCost) {
        mentalEnergy -= energyCost;

        System.out.println("Studying: " + s.name);
        System.out.println("Difficulty: " + s.difficulty);
        System.out.println("Duration: " + s.duration + " mins");
        System.out.println("Energy Left: " + mentalEnergy);
        System.out.println("----------------------------------");
    }

    private void takeBreak() {
        System.out.println("\n🧘 Mental energy low! Taking a smart break...");
        mentalEnergy += 30;
        if (mentalEnergy > 100)
            mentalEnergy = 100;
        System.out.println("Energy Restored to: " + mentalEnergy);
        System.out.println("----------------------------------");
    }
}

public class SmartStudyAI {
    public static void main(String[] args) {

        CognitiveOptimizer optimizer = new CognitiveOptimizer();

        optimizer.addSubject("Data Structures", 9, 60);
        optimizer.addSubject("Operating Systems", 8, 50);
        optimizer.addSubject("DBMS", 7, 45);
        optimizer.addSubject("Aptitude", 4, 30);
        optimizer.addSubject("Java Revision", 6, 40);

        optimizer.optimizeSchedule();
    }
}