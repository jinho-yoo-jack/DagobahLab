package org.jedi.lab.dagobahlab.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "MEBMER")
@Entity
public class Member {
    @Id
    @Column(name = "user_id", nullable = false)
    private String id;

    private String password;

    private String role;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
