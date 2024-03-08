package smart.projet.GestionGarage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, updatable = true)
    private String password;
    @Column(unique = true)
    private String nni;
    @Column(unique = true)
    private String phoneNumber;
    private String address;


    @ManyToOne(optional = true)
    private Role role;

    @CreationTimestamp
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
