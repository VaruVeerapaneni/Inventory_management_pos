package com.rafsan.inventory;

/**
 * Entry point launcher for executable shaded JAR packaging.
 * Avoids JavaFX runtime module path restrictions when launched via java -jar.
 */
public class Launcher {

    public static void main(String[] args) {
        MainApp.main(args);
    }
}
