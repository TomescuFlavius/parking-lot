package app.Users.UserQuery;

public class UserQueryServiceSingleton {
    private static class Lazy{
        private static final UserQueryService USER_QUERY_SERVICE= new UserQueryServiceImpl();
    }

    public static UserQueryService getInstance(){
        return Lazy.USER_QUERY_SERVICE;
    }
}
