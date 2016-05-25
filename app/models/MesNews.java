package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kirill on 5/21/16.
 */
@Entity
public class MesNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String title;

    public String author;

    public long date;

    public String source;

}