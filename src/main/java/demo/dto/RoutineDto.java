package demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoutineDto {
    private Long id;
    private Long userId;
    private Long exerciseId;
    private int sets;
    private int reps;
    private double weight;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private Character deletedYn;
}
