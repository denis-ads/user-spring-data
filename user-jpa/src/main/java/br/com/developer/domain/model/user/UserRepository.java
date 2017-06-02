package br.com.developer.domain.model.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByDocument(String document);

    List<User> findByNameStartingWith(String nome);

}
