package demo.service.routine;

import demo.dto.ExerciseDto;
import demo.dto.RoutineDto;
import demo.dto.RoutineExerciseDto;

import java.util.List;
import java.util.Map;

public interface RoutineService {
    Map<Integer, RoutineExerciseDto> deleteBucketExercise(Integer bucketIdx);
    boolean addRoutine(RoutineDto routineDto);
    Map<Integer, RoutineExerciseDto> addBucketExercise(ExerciseDto exerciseDto, Integer reps, Integer sets, Integer weight);

    List<RoutineExerciseDto> getBucketExercise();

    List<RoutineDto> getRoutineList(Long userId);
}
