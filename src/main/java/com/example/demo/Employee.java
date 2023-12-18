package com.example.demo;

import java.util.List;

public class Employee {
    private String FirstName;
    private String LastName;
    private String EmployeeID;
    private String Designation;
    private List<KnownLanguage> knownLanguages;

    // Constructors

    // Getters and Setters
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public List<KnownLanguage> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(List<KnownLanguage> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    public static class KnownLanguage {
        private String LanguageName;
        private int ScoreOutof100;

        // Constructors

        // Getters and Setters
        public String getLanguageName() {
            return LanguageName;
        }

        public void setLanguageName(String LanguageName) {
            this.LanguageName = LanguageName;
        }

        public int getScoreOutof100() {
            return ScoreOutof100;
        }

        public void setScoreOutof100(int ScoreOutof100) {
            this.ScoreOutof100 = ScoreOutof100;
        }
    }
}
