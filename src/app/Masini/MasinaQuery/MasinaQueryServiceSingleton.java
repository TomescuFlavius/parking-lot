package app.Masini.MasinaQuery;

public class MasinaQueryServiceSingleton{
    private static class Lazy{
        private static final MasinaQueryService MASINA_QUERY_SERVICE=new MasinaQueryServiceImpl();
    }
    public static MasinaQueryService getInstance(){
        return Lazy.MASINA_QUERY_SERVICE;
    }
}
