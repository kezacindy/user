

import view.UserView;

public class Main {
    public static void main(String[] args) {
        try {
            UserView userView = new UserView();
            userView.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
