package gr.vbatsalis.MoneySplitApplication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String description;
    private int value;

//    @JsonIgnore
    private LocalDateTime localDateTime = LocalDateTime.now();

}
