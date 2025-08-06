package app.Users.UserComand;

import app.Users.Model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserComandServiceImpl implements UserComandService {
    private File file;
    private List<User> users;


    public UserComandServiceImpl() {
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



    public String toSaveUsers() {
        String text = "";
        int i;
        for ( i = 0; i < this.users.size()-1; i++) {
            text += users.get(i).toString() + "\n";
        }
        return text += users.get(i).toString();
    }

    public void saveUsers() {
        try {
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(toSaveUsers());
            printWriter.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public User add(User user) {
        users.add(user);
        saveUsers();
        return user;
    }
}
