package id.swhp.javaee.guestbook.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
    private Long id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
