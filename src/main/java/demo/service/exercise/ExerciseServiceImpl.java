package demo.service.exercise;

import demo.dto.ExerciseDto;
import demo.mapper.exercise.ExerciseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    ExerciseMapper exerciseMapper;

    @Override
    public List<ExerciseDto> getUserExercise(Integer userId) {
        return exerciseMapper.getUserExercise(Long.valueOf(userId));
    }

    @Override
    public boolean addExercise(ExerciseDto exerciseDto) {
        int result = exerciseMapper.addExercise(exerciseDto);
        return result == 1;
    }

    @Override
    public boolean deleteExercise(Long exerciseId) {
        int result = exerciseMapper.deleteExercise(exerciseId);
        return result == 1;
    }

    @Override
    public ExerciseDto getExercise(Long exerciseId) {
        return exerciseMapper.getExercise(exerciseId);
    }

    @Override
    public boolean updateExercise(ExerciseDto exerciseDto) {
        int result = exerciseMapper.updateExercise(exerciseDto);
        return result == 1;
    }
}
