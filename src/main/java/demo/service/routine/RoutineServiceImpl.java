package demo.service.routine;

import demo.dto.ExerciseDto;
import demo.dto.RoutineDto;
import demo.dto.RoutineExerciseDto;
import demo.mapper.routine.RoutineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoutineServiceImpl  implements RoutineService {
    private Map<Integer, RoutineExerciseDto> bucketRoutine = new HashMap<>();
    private int currentBucketKey = 0;

    @Autowired
    private RoutineMapper routineMapper;

    @Override
    public Map<Integer, RoutineExerciseDto> addBucketExercise(ExerciseDto exerciseDto, Integer reps, Integer sets, Integer weight) {
        RoutineExerciseDto routineExerciseDto = new RoutineExerciseDto();
        routineExerciseDto.setExercise(exerciseDto);
        routineExerciseDto.setReps(reps);
        routineExerciseDto.setSets(sets);
        routineExerciseDto.setWeight(weight);

        System.out.println("RoutineExerciseDto : " + routineExerciseDto);
        this.bucketRoutine.put(currentBucketKey++, routineExerciseDto);
        return this.bucketRoutine;
    }

    @Override
    public Map<Integer, RoutineExerciseDto> deleteBucketExercise(Integer bucketIdx) {
        this.bucketRoutine.remove(bucketIdx);
        return this.bucketRoutine;
    }


    @Transactional
    @Override
    public boolean addRoutine(RoutineDto routineDto) {
        routineMapper.insertRoutine(routineDto);

        for(RoutineExerciseDto exercise : routineDto.getRoutineExercises()) {
            exercise.setRoutineId(routineDto.getId());
            routineMapper.insertRoutineExercise(exercise);
        }
        return true;
    }

    @Override
    public List<RoutineExerciseDto> getBucketExercise() {
        return new ArrayList<>(this.bucketRoutine.values());
    }

    @Override
    public List<RoutineDto> getRoutineList(Long userId) {
        List<RoutineDto> list = routineMapper.getRoutine(userId);
        return list;
    }
}
