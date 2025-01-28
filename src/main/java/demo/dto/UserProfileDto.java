package demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserProfileDto {
    private Long id;
    private String username;
    private double currentBodyFat;
    private double currentMuscleMass;
    private double targetBodyFat;
    private double targetMuscleMass;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private Character deletedYn;
}
