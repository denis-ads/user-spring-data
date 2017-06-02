package br.com.developer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.developer.application.util.DateUtil;
import br.com.developer.domain.model.user.Contact;
import br.com.developer.domain.model.user.User;
import br.com.developer.domain.model.user.UserRepository;

@Component
public class CargaInicialJpa {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void carregarDadosIniciaisClientesPf() {
        repository.deleteAll();
        User user = new User(1L, "12345678901", "Joao da Silva", "M", DateUtil.toLocalDate("01/12/1981"),
                new Contact(1L, null, "joao@teste.com"));

        repository.save(user);

        user = new User(2L, "98765432102", "Maria da SIlva", "F", DateUtil.toLocalDate("28/05/1981"),
                new Contact(2L, "999978901", "Maria@teste.com"));
        repository.save(user);
    }
}
