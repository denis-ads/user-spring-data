package br.com.developer.application.service;

import java.util.List;

import br.com.developer.application.exception.ServiceException;
import br.com.developer.domain.model.user.User;
import br.com.developer.interfaces.user.dto.UserDto;

public interface UserService {

    User create(User entity) throws ServiceException;

    User update(User entity) throws ServiceException;

    List<User> findByNameStartingWith(String name) throws ServiceException;

    UserDto findById(Long id) throws ServiceException;

    void deleteById(Long id) throws ServiceException;

}