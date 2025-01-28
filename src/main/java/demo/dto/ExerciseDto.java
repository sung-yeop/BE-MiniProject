package demo.dto;

import lombok.Data;

@Data
public class ExerciseDto {
    private Long id;
    private String name;
    private String targetMuscle;
    private String exerciseType;
    private String description;
    private Character deletedYn;
}
