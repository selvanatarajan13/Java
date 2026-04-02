package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLog {

    // Singleton - one log for the whole system
    private static AuditLog instance;
    private List<String> logs;

    public AuditLog() {
        this.logs = new ArrayList<>();
    }

    public static AuditLog getInstance() {
        if (instance == null) {
            return new AuditLog();
        }
        return instance;
    }

    public void log(String action) {
        String entry = LocalDateTime.now() + " → " + action;
        logs.add(entry);
        System.out.println("Log: " + entry);
    }

    public void showAllLogs() {
        System.out.println("\n========== AUDIT LOGS ==========");
        logs.forEach(System.out::println);
    }
}
