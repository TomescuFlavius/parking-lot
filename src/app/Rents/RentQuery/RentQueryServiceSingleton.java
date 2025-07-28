package app.Rents.RentQuery;

public class RentQueryServiceSingleton {
    private static class Lazy{
        private static final RentQueryService RENT_QUERY_SERVICE=new RentQueryServiceImpl();
    }

    public static RentQueryService getInstance(){
        return Lazy.RENT_QUERY_SERVICE;
    }
}
