package id.swhp.javaee.guestbook.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Entity
@Table(name = "guest_book")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = GuestBook.FIND_ALL, query = "select g from GuestBook g")
public class GuestBook {

    public static final String FIND_ALL = "findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Override
    public String toString() {
        return new StringBuilder("GuestBook [")
                .append(id).append(", ")
                .append(name).append(", ")
                .append(created).append("]").toString();
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("name", this.name)
                .add("created", this.created.toString())
                .build();
    }
}
