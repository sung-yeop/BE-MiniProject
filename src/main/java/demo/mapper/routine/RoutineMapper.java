package demo.mapper.routine;

import demo.dto.ExerciseDto;
import demo.dto.RoutineDto;
import demo.dto.RoutineExerciseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoutineMapper {
    void insertRoutine(RoutineDto routineDto);
    void insertRoutineExercise(RoutineExerciseDto exercise);
    List<RoutineDto> getRoutine(Long userId);
}
