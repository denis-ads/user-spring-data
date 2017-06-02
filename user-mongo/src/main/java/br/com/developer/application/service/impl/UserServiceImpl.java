package br.com.developer.application.service.impl;

import static java.util.Objects.isNull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.developer.application.exception.ServiceException;
import br.com.developer.application.service.UserService;
import br.com.developer.domain.model.ResponseDefault;
import br.com.developer.domain.model.user.User;
import br.com.developer.domain.model.user.UserRepository;
import br.com.developer.interfaces.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDto findByDocument(final String document) throws ServiceException {

        if (isNull(document)) {
            throw new ServiceException(new ResponseDefault(null, HttpStatus.UNPROCESSABLE_ENTITY,
                    String.format("CorrelationId não encontrado para o document {}", document)));
        }

        try {

            final User user = repository.findByDocument(document);

            if (isNull(user)) {
                LOGGER.error(String.format("Cliente não encontrado para o document {}", document));
                throw new ServiceException(new ResponseDefault(null, HttpStatus.UNPROCESSABLE_ENTITY,
                        String.format("Usuario não encontrado para o document {}", document)));
            }

            return UserDto.construir(user);
        } catch (final Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findByNameStartingWith(final String nome) throws ServiceException {
        try {
            return repository.findByNameStartingWith(nome);
        } catch (final Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User create(final User entity) throws ServiceException {
        try {

            return repository.save(entity);
        } catch (final Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteById(final Long id) throws ServiceException {
        User entity;
        try {
            entity = repository.findOne(id);
            if (entity == null) {
                throw new IllegalArgumentException("Objeto não encontrado");
            }
            repository.delete(entity);
        } catch (final Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User update(final User entity) throws ServiceException {
        try {
            return repository.save(entity);
        } catch (final Exception e) {
            throw new ServiceException(e);
        }
    }

}
