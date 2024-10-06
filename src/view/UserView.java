package view;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private UserDAO userDAO;
    private Scanner scanner;

    public UserView() throws SQLException {
        userDAO = new UserDAO();
        scanner = new Scanner(System.in);
    }

    public void showMenu() throws Exception {
        while (true) {
            System.out.println("User Management Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. List All Users");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1: addUser(); break;
                case 2: getUser(); break;
                case 3: updateUser(); break;
                case 4: deleteUser(); break;
                case 5: listUsers(); break;
                case 6: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void addUser() throws Exception {
        User user = new User();
        scanner.nextLine();  // Clear buffer
        System.out.print("Enter Name: ");
        user.setName(scanner.nextLine());

        System.out.print("Enter DOB (yyyy-MM-dd): ");
        String dobStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setDob(sdf.parse(dobStr));

        System.out.print("Enter Email: ");
        user.setEmail(scanner.nextLine());

        System.out.print("Enter Gender: ");
        user.setGender(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        user.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter Province: ");
        user.setProvince(scanner.nextLine());

        System.out.print("Enter Title: ");
        user.setTitle(scanner.nextLine());

        System.out.print("Enter District: ");
        user.setDistrict(scanner.nextLine());

        System.out.print("Enter Password: ");
        user.setPassword(scanner.nextLine());

        userDAO.addUser(user);
        System.out.println("User added successfully!");
    }

    private void getUser() throws SQLException {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        User user = userDAO.getUser(userId);
        if (user != null) {
            System.out.println("User Details:");
            System.out.println("Name: " + user.getName());
            System.out.println("DOB: " + user.getDob());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Gender: " + user.getGender());
            System.out.println("Phone Number: " + user.getPhoneNumber());
            System.out.println("Province: " + user.getProvince());
            System.out.println("Title: " + user.getTitle());
            System.out.println("District: " + user.getDistrict());
            System.out.println("Password: " + user.getPassword());
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateUser() throws Exception {
        System.out.print("Enter User ID to update: ");
        int userId = scanner.nextInt();
        User user = userDAO.getUser(userId);
        if (user != null) {
            scanner.nextLine();  // Clear buffer
            System.out.print("Enter new Name: ");
            user.setName(scanner.nextLine());

            System.out.print("Enter new DOB (yyyy-MM-dd): ");
            String dobStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setDob(sdf.parse(dobStr));

            System.out.print("Enter new Email: ");
            user.setEmail(scanner.nextLine());

            System.out.print("Enter new Gender: ");
            user.setGender(scanner.nextLine());

            System.out.print("Enter new Phone Number: ");
            user.setPhoneNumber(scanner.nextLine());

            System.out.print("Enter new Province: ");
            user.setProvince(scanner.nextLine());

            System.out.print("Enter new Title: ");
            user.setTitle(scanner.nextLine());

            System.out.print("Enter new District: ");
            user.setDistrict(scanner.nextLine());

            System.out.print("Enter new Password: ");
            user.setPassword(scanner.nextLine());

            userDAO.updateUser(user);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser() throws SQLException {
        System.out.print("Enter User ID to delete: ");
        int userId = scanner.nextInt();
        userDAO.deleteUser(userId);
        System.out.println("User deleted successfully!");
    }

    private void listUsers() throws SQLException {
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user.getUserId() + " - " + user.getName() + " (" + user.getEmail() + ")");
        }
    }
}
