package gr.vbatsalis.MoneySplitApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "money_split")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "description")
    private String description;

    @Column(name="value")
    private int value;

//    @JsonIgnore
    @Column(name = "local_date")
    private LocalDateTime localDateTime = LocalDateTime.now();

}
