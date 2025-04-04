package app.Users;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> users=new ArrayList<>();
    public void loadUsers() {
        User u1=new User();
        u1.id=1;
        u1.adresa="A1";
        u1.email="a@a.a";
        u1.password="123";

        User u2=new User();
        u1.id=2;
        u1.adresa="B1";
        u1.email="b@b.a";
        u1.password="1234";

        User u3=new User();
        u1.id=3;
        u1.adresa="C1";
        u1.email="a@c.a";
        u1.password="12313";

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }



}
