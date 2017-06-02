package br.com.developer.interfaces.user.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.developer.domain.model.user.Contact;
import br.com.developer.domain.model.user.User;
import br.com.developer.infrastructure.converter.LocalDateDeserializer;
import br.com.developer.infrastructure.converter.LocalDateSerializer;

@JsonInclude(Include.NON_NULL)
public class UserDto implements Serializable {

    private static final long serialVersionUID = -6433357760896254190L;

    @Id
    private Long id;

    private String document;

    private String name;

    private String sex;

    // @DateTimeFormat(iso =ISO.DATE)
    // @JsonSerialize(using = DateSerializer.class)
    // @JsonDeserialize(using = DateDeserializer.class)
    // @JsonFormat(pattern = "dd/mm/yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    // @DateTimeFormat(iso = ISO.DATE)
    // @DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    // @Field
    private LocalDate bornDate;

    private Contact contact;

    public static UserDto construir(final User user) {
        final UUID uuid = UUID.randomUUID();
        final UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setContact(user.getContact());
        dto.setDocument(user.getDocument());
        dto.setBornDate(user.getBornDate());
        dto.setName(user.getName());
        dto.setSex(user.getSex());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(final String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(final LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(final Contact contact) {
        this.contact = contact;
    }

}
