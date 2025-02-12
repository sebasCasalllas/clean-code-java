package org.example.cleanCode;

import java.util.Date;

/***************
 * APLICANDO EL
 * PRINCIPIO DE RESPONSABILIDAD UNICA
 *
 * PRIORIZAR LA COMPOSICION FRENTE
 * A LA HERENCIA
 * **************/
public class Classes06C {

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

        @Override
        public String toString() {
            return "Person{" +
                    "\nname='" + name + '\n' +
                    "gender=" + gender +
                    "\nbirthdate=" + birthdate + "\n" +
                    '}';
        }
    }

    public static class User {
        public String email;
        public Date lastAccess;
        public String role;

        public User(String email, String role) {
            this.email = email;
            this.lastAccess = new Date();
            this.role = role;
        }

        public boolean checkCredentials(){
            return true;
        }

        @Override
        public String toString() {
            return "User{" +
                    "\nemail='" + email + '\n' +
                    "lastAccess=" + lastAccess +
                    "\nrole='" + role + '\n' +
                    '}';
        }
    }

    public static class Settings {
        public String workingDirectory;
        public String lastOpenFolder;

        public Settings(String workingDirectory, String lastOpenFolder) {
            this.workingDirectory = workingDirectory;
            this.lastOpenFolder = lastOpenFolder;
        }

        @Override
        public String toString() {
            return "Settings{" +
                    "\nworkingDirectory='" + workingDirectory + '\'' +
                    "\nlastOpenFolder='" + lastOpenFolder + '\n' +
                    '}';
        }
    }

    public static class UserSettings {
        public Person person;
        public User user;
        public Settings settings;

        @Override
        public String toString() {
            return "UserSettings{" +
                    "\nperson=" + person +
                    "\nuser=" + user +
                    "\nsettings=" + settings + "\n" +
                    '}';
        }

        public UserSettings(String name,
                            Gender gender,
                            Date birthdate,
                            String email,
                            String role,
                            String workingDirectory,
                            String lastOpenFolder) {
            this.person = new Person(name, gender, birthdate);
            this.user = new User(email, role);
            this.settings = new Settings(workingDirectory, lastOpenFolder);


        }
    }

    public static void main(String[] args) {

        UserSettings userSettings = new UserSettings(
                "Jhoan",
                Gender.M,
                new Date(),
                "j@mail.com",
                "admin",
                "usr/home/",
                "/home"
                );

        System.out.println(userSettings);
        userSettings.user.checkCredentials();
    }
}
