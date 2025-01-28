package demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkoutLogDto {
    private Long id;
    private Long userId;
    private Long routineId;
    private LocalDateTime workoutDate;
    private String content;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private Character deletedYn;
}
