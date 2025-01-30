package demo.service.exercise;

import demo.dto.ExerciseDto;

import java.util.List;

public interface ExerciseService {

    List<ExerciseDto> getUserExercise(Integer userId);

    boolean addExercise(ExerciseDto exerciseDto);


    boolean deleteExercise(Long id);

    ExerciseDto getExercise(Long exerciseId);

    boolean updateExercise(ExerciseDto exerciseDto);

}

