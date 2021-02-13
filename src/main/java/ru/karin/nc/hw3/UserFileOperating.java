package ru.karin.nc.hw3;

import ru.karin.nc.hw3.model.User;
import ru.karin.nc.hw3.model.UserKey;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class UserFileOperating {

    private static Path userFile = Paths.get("UsersFile.txt");


    public static void AddUser(User user) throws IOException {
        if (!Files.exists(userFile)) {
            Files.createFile(userFile);
        }
        if (FindUser(user.getFirstName(), user.getLastName()) != null) {
            deleteUser(user.getFirstName(), user.getLastName());
        }
        Files.write(userFile, Arrays.asList(user.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public static void addFromFile(Path userFile) throws IOException {
        Scanner sc = new Scanner(userFile);
        while (sc.hasNextLine()) {
            String userStr = sc.nextLine();
            String[] parseUser = userStr.split("#");
            if (parseUser.length == 6) {
                User user = new User(parseUser);
                AddUser(user);
            }
        }
    }

    public static User FindUser(String firstName, String lastName) throws IOException {
        Scanner sc = new Scanner(userFile);
        while (sc.hasNextLine()) {
            String fileUser = sc.nextLine();
            String[] splitUser = fileUser.split("#");
            if (splitUser[0].equals(firstName) && splitUser[1].equals(lastName)) {
                return new User(splitUser);
            }
        }
        return null;
    }

    public static User FindUser(UserKey uk) throws IOException {
        Scanner sc = new Scanner(userFile);
        while (sc.hasNextLine()) {
            String fileUser = sc.nextLine();
            String[] splitUser = fileUser.split("#");
            if (splitUser[0].equals(uk.getFirstName()) && splitUser[1].equals(uk.getLastName())) {
                return new User(splitUser);
            }
        }
        return null;
    }

    public static void deleteUser(String firstName, String lastName) throws IOException {
        Scanner sc = new Scanner(userFile);
        Path tempFile = Paths.get("tempUsersFile.txt");
        Files.createFile(tempFile);
        while (sc.hasNextLine()) {
            String fileUser = sc.nextLine();
            String[] splitUser = fileUser.split("#");
            if (!(splitUser[0].equals(firstName) && splitUser[1].equals(lastName))) {
                Files.write(tempFile, Arrays.asList(fileUser), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
        }
        Files.delete(userFile);
        Files.move(tempFile, userFile);
    }

}
