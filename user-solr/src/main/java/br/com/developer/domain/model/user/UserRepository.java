package br.com.developer.domain.model.user;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface UserRepository extends SolrCrudRepository<User, Long> {

    User findByDocument(String document);

    List<User> findByNameStartingWith(String nome);

}
