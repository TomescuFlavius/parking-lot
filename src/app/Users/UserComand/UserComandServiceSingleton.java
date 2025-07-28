package app.Users.UserComand;

public class UserComandServiceSingleton {
    private static class LazyHolder{
        private static final UserComandService USER_COMAND_SERVICE=new UserComandServiceImpl();
    }

    public static UserComandService getInstance(){
        return LazyHolder.USER_COMAND_SERVICE;
    }


}
