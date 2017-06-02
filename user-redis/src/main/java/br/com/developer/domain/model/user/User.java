package br.com.developer.domain.model.user;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.developer.domain.shared.Entity;

@JsonInclude(Include.NON_NULL)
@RedisHash("user")
public class User implements Entity<User, Long> {

    private static final long serialVersionUID = 1206398681381801374L;

    @Id
    private Long id;
    private String document;

    private String name;

    private String sex;

    // @DateTimeFormat(iso =ISO.DATE)
    // @JsonSerialize(using = DateSerializer.class)
    // @JsonDeserialize(using = DateDeserializer.class)
    // @JsonFormat(pattern = "dd/mm/yyyy")
    // @JsonSerialize(using = LocalDateSerializer.class)
    // @JsonDeserialize(using = LocalDateDeserializer.class)
    // // @DateTimeFormat(iso = ISO.DATE)
    // // @DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
    // @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR")
    // @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    // // @Field
    // private LocalDate bornDate;

    private Contact contact;

    public User() {
        super();
    }

    public User(final Long id, final String document, final String name, final String sex, final LocalDate bornDate,
            final Contact contact) {
        super();
        this.id = id;
        this.document = document;
        this.name = name;
        this.sex = sex;
        // this.bornDate = bornDate;
        this.contact = contact;
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

    // public LocalDate getBornDate() {
    // return bornDate;
    // }
    //
    // public void setBornDate(final LocalDate bornDate) {
    // this.bornDate = bornDate;
    // }

    public Contact getContact() {
        return contact;
    }

    public void setContact(final Contact contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", document=");
        builder.append(document);
        builder.append(", name=");
        builder.append(name);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", bornDate=");
        // builder.append(bornDate);
        builder.append(", contact=");
        builder.append(contact);
        builder.append("]");
        return builder.toString();
    }

}
