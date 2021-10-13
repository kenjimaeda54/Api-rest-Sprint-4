package br.com.fiap.resource.yourfriend.service;

import br.com.fiap.resource.yourfriend.dao.BotDao;
import br.com.fiap.resource.yourfriend.dao.implemantation.BootImplements;
import br.com.fiap.resource.yourfriend.domain.Boot;

import java.util.List;

public class BootService {
    BootImplements boot = new BootImplements();



    public List<Boot> getALlBot() {
        return boot.getAllBot();
    }





}
