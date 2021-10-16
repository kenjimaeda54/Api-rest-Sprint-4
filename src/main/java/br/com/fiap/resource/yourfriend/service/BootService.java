package br.com.fiap.resource.yourfriend.service;

import br.com.fiap.resource.yourfriend.dao.BotDao;
import br.com.fiap.resource.yourfriend.dao.implemantation.BootImplements;
import br.com.fiap.resource.yourfriend.domain.Boot;

import java.util.List;

public class BootService {
    BootImplements bootDao = new BootImplements();


    public List<Boot> getALlBot() {
        return bootDao.getAllBot();
    }

//    public  void  insertPhases(Boot boot) {
//        bootDao.insertPhrases(boot);
//    }

}
