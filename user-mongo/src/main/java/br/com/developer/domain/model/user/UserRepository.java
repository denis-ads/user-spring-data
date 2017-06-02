package br.com.developer.domain.model.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByDocument(String document);

    List<User> findByNameStartingWith(String nome);

}
