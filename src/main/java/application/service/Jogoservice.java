package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.record.JogoDTO;
import application.model.Jogo;
import application.repository.JogoRepository;

@Service
public class Jogoservice {
    @Autowired
    private JogoRepository jogoRepo;

    public Iterable<JogoDTO> getAll(){
        return jogoRepo.findAll().stream().map(JogoDTO::new).toList();
    }

    public JogoDTO add(JogoDTO jogo){
        return new JogoDTO(jogoRepo.save(new Jogo(jogo)));
    }
}
