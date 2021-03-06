package com.ridwan.conferenceApplicationByRidwan.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handle"})
public class Speaker {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;
    @Lob//case of large objects
    @Type(type = "org.hibernate.type.BinaryType")//using hibenate for binarydate
    private byte[] speaker_Photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Session> session;
    //constructors
    public Speaker(){
    }
    //methods
    public byte[] getSpeaker_Photo() {
        return speaker_Photo;
    }
    public void setSpeaker_Photo(byte[] speaker_Photo) {
        this.speaker_Photo = speaker_Photo;
    }
    public List<Session> getSession() {
        return session;
    }
    public void setSession(List<Session> session) {
        this.session = session;
    }
    public long getSpeaker_id() {
        return speaker_id;
    }
    public void setSpeaker_id(long speaker_id) {
        this.speaker_id = speaker_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getSpeaker_bio() {
        return speaker_bio;
    }
    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
