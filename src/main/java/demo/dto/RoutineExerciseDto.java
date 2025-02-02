package demo.dto;

import lombok.Data;

@Data
public class RoutineExerciseDto {
    private Long id;
    private Long routineId;
    private ExerciseDto exercise;
    private int reps;
    private int sets;
    private int weight;
}
