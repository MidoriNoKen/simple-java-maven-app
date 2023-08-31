package com.mycompany.app;

import spark.*;

public class App {
    private static final String MESSAGE = "Hello World!";

    public App() {
    }

    public static void main(String[] args) {
        Spark.port(getHerokuAssignedPort()); // Set port based on Heroku environment
        get("/", (req, res) -> MESSAGE);
    }

    public String getMessage() {
        return MESSAGE;
    }

    // Get assigned port from Heroku environment
    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // Default port if not found
    }
}
