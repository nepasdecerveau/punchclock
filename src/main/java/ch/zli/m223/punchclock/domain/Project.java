package ch.zli.m223.punchclock.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Project {
    private Long id;
    private String name;
    private LocalDateTime end_at;

    public Project(String name, LocalDateTime end_at){
        this.name = name;
        this.end_at = end_at;
    }
    public Project(){

    }

    public void setId(Long id){this.id = id;}

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEnd_at() {
        return end_at;
    }

    public void setEnd_at(LocalDateTime end_at) {
        this.end_at = end_at;
    }
}
