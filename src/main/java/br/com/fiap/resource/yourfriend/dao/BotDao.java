package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.domain.Boot;

import java.util.List;

public interface BotDao {
    List<Boot> getAllBot();
    void insertPhrases(Boot boot);

     
}
