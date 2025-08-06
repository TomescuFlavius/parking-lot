package app.Users.UserQuery;

import app.Users.Model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserQueryServiceImpl implements UserQueryService {
    private File file;
    private List<User> users;


    public UserQueryServiceImpl() {
        this.file=new File("C:\\mycode\\oop\\incapsulare\\parc-auto\\src\\app\\Users\\File\\Users");
        this.users=new ArrayList<>();
        this.loadUsers();
    }
    public void loadUsers() {
        try{
            Scanner scanner=new Scanner(this.file);
            while(scanner.hasNextLine()) {
                String line=scanner.nextLine();
                User user=new User(line);
                users.add(user);

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String text = "";
        int i;
        for (i = 0; i < this.users.size() - 1; i++) {
            text += users.get(i).toString() + "\n";
        }
        text += users.get(i).toString();
        return  text;
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
}
