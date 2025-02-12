package org.example.clean;

import java.util.Date;


/***************
 * NO APLICA EL
 * PRINCIPIO DE RESPONSABILIDAD UNICA
 * **************/
public class Classes06A {

    public enum Gender {
        M, F
    }

    public static class Person {
        public String name;
        public Gender gender;
        public Date birthdate;

        public Person(String name, Gender gender, Date birthdate) {
            this.name = name;
            this.gender = gender;
            this.birthdate = birthdate;
        }
    }

    public static class User extends Person {
        public Date lastAccess;

        public User(String name, Gender gender, Date birthdate) {
            super(name, gender, birthdate);
            this.lastAccess = new Date();
        }

        public boolean checkCredentials(){
            return true;
        }
    }

    public static class UserSettings extends User{
        public String workingDirectory;
        public String lastOpenFolder;

        public UserSettings(String name,
                            Gender gender,
                            Date birthdate,
                            String workingDirectory,
                            String lastOpenFolder) {
            super(name, gender, birthdate);
            this.workingDirectory = workingDirectory;
            this.lastOpenFolder = lastOpenFolder;
        }

        @Override
        public String toString() {
            return "UserSettings{" +
                    "workingDirectory='" + workingDirectory + '\n' +
                    ", lastOpenFolder='" + lastOpenFolder + '\n' +
                    ", lastAccess=" + lastAccess +
                    ", name='" + name + '\n' +
                    ", gender=" + gender +
                    ", birthdate=" + birthdate +
                    '}';
        }
    }

    public static void main(String[] args) {

        UserSettings userSettings = new UserSettings("Jhoan",
                Gender.M,
                new Date(),
                "usr/home/",
                "/home"
                );

        System.out.println(userSettings);
    }
}
