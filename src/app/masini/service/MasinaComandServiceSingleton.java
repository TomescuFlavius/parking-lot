package app.masini.service;

import app.masini.service.intefaces.MasinaComandService;

public class MasinaComandServiceSingleton{
    private static class LazyHolder{
        private static final MasinaComandService MASINA_COMAND_SERVICE=new MasinaComandServiceImpl();
    }
    public static MasinaComandService getInstance(){
        return LazyHolder.MASINA_COMAND_SERVICE;
    }
}
