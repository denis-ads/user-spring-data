package br.com.developer.interfaces.user;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.net.URI;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.developer.application.exception.ServiceException;
import br.com.developer.application.service.UserService;
import br.com.developer.domain.model.ResponseDefault;
import br.com.developer.domain.model.user.User;
import br.com.developer.interfaces.user.dto.UserDto;

@RestController()
@RequestMapping("/user")
public class UserEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEndpoint.class);

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{document}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = {
            MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> findByDocument(@PathVariable("document") final String document,
            @RequestParam("correlationId") final String correlationId) {

        try {
            final UserDto entity = service.findByDocument(document);

            LOGGER.debug("Fim do teste:{} ", correlationId);
            return ResponseEntity.ok(entity);

        } catch (final Exception e) {
            LOGGER.error(correlationId + " - " + e.getMessage(), e);
            final ResponseDefault response = new ResponseDefault(correlationId, HttpStatus.UNPROCESSABLE_ENTITY,
                    e.getMessage());
            return ResponseEntity.unprocessableEntity()
                    .body(new ResponseDefault(correlationId, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> create(@RequestParam("correlationId") final String correlationId,
            @RequestBody User entity) {

        final UUID uuid = UUID.randomUUID();

        try {
            if (nonNull(entity.getId())) {
                LOGGER.error("Codigo User inválido uui: " + uuid);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            if (isNull(entity.getDocument())) {
                LOGGER.error("Codigo User inválido uui: " + uuid);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            final Random rand = new Random();
            final int max = 30000;
            final int min = 100;
            final int n = rand.nextInt((max - min) + 1) + min;

            entity.setId(Long.valueOf(n));
            LOGGER.debug("inicio do teste:{} ", uuid);
            entity = service.create(entity);

            final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (final Exception e) {
            LOGGER.error(uuid + " - " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{id:[0-9][0-9]*}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id,
            @RequestParam("correlationId") final String correlationId, User entity) {

        final UUID uuid = UUID.randomUUID();

        if (isNull(entity)) {
            LOGGER.error("User inválido uui: " + uuid);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (isNull(id)) {
            LOGGER.error("Id inválido uui: " + uuid);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (!id.equals(entity.getId())) {
            LOGGER.error("Id inválido uui: " + uuid);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(entity);
        }

        try {
            LOGGER.debug("inicio :{} ", uuid);
            entity = service.update(entity);

        } catch (final ServiceException e) {
            LOGGER.error(uuid + " - " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id:[0-9][0-9]*}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable("id") final Long id,
            @RequestParam("correlationId") final String correlationId) {

        final UUID uuid = UUID.randomUUID();

        try {

            LOGGER.debug("inicio do teste:{} ", uuid);
            service.deleteById(id);

            return ResponseEntity.noContent().build();
        } catch (final ServiceException e) {
            LOGGER.error(uuid + " - " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (final Exception e) {
            LOGGER.error(uuid + " - " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
