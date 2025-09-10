package app.masini.service;

import app.masini.service.intefaces.MasinaQueryService;

public class MasinaQueryServiceSingleton{
    private static class Lazy{
        private static final MasinaQueryService MASINA_QUERY_SERVICE=new MasinaQueryServiceImpl();
    }
    public static MasinaQueryService getInstance(){
        return Lazy.MASINA_QUERY_SERVICE;
    }
}
