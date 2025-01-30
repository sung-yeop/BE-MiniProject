package demo.mapper.exercise;

import demo.dto.ExerciseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<ExerciseDto> getUserExercise(Long userId);
    Integer addExercise(ExerciseDto exerciseDto);
    Integer deleteExercise(Long exerciseId);
    ExerciseDto getExercise(Long exerciseId);
    Integer updateExercise(ExerciseDto exerciseDto);
}




