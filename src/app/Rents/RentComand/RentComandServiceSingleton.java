package app.Rents.RentComand;

public class RentComandServiceSingleton {
    private static class LazyHolder{
        private static final RentComandService RENT_COMAND_SERVICE = new RentComandServviceImpl();
    }
    public static RentComandService getInstance(){
        return LazyHolder.RENT_COMAND_SERVICE;
    }
}
