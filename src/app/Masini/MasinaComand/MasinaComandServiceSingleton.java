package app.Masini.MasinaComand;

public class MasinaComandServiceSingleton{
    private static class LazyHolder{
        private static final MasinaComandService MASINA_COMAND_SERVICE=new MasinaComandServiceImpl();
    }
    public static MasinaComandService getInstance(){
        return LazyHolder.MASINA_COMAND_SERVICE;
    }
}
