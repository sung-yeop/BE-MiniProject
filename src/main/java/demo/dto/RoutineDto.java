package demo.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoutineDto {
    private Long id;
    private Long userId;
    private List<RoutineExerciseDto> routineExercises;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private Character deletedYn;
}
