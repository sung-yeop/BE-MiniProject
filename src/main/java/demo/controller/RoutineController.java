package demo.controller;

import demo.dto.ExerciseDto;
import demo.dto.RoutineDto;
import demo.dto.RoutineExerciseDto;
import demo.service.exercise.ExerciseService;
import demo.service.routine.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class RoutineController {
    @Autowired
    RoutineService routineService;

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/routine.do")
    public ModelAndView homeRoutine(@RequestParam ("userId") Long userId) {
        ModelAndView mv = new ModelAndView("/routine/routineList");
        List<ExerciseDto> exerciseList = exerciseService.getUserExercise(userId);
        List<RoutineDto> routineList = routineService.getRoutineList(userId);
        mv.addObject("userId", userId);
        mv.addObject("exerciseList", exerciseList);
        mv.addObject("routineList", routineList);

        System.out.println("RoutineList : " + routineList);

        return mv;
    }

    @PostMapping("/routine/bucket/add")
    @ResponseBody
    public ResponseEntity<Map<Integer, RoutineExerciseDto>>  addRoutineExercise(@RequestParam("exerciseId") Long exerciseId,
            @RequestParam("reps") Integer reps, @RequestParam("sets") Integer sets, @RequestParam("weight") Integer weight) {
        ExerciseDto exerciseDto = exerciseService.getExercise(exerciseId);
        Map<Integer, RoutineExerciseDto> bucketList = routineService.addBucketExercise(exerciseDto, reps, sets, weight);

        return ResponseEntity.ok(bucketList);
    }

    @PostMapping("/routine/bucket/delete")
    @ResponseBody
    public ResponseEntity<Map<Integer, RoutineExerciseDto>> deleteRoutineExercise(@RequestParam("bucketIdx") Integer bucketIdx
    ) {
        Map<Integer, RoutineExerciseDto> bucketList = routineService.deleteBucketExercise(bucketIdx);
        return ResponseEntity.ok(bucketList);
    }

    @PostMapping("/routine/add")
    public String addRoutine(@RequestParam("userId") Long userId) {
        RoutineDto routineDto = new RoutineDto();
        List<RoutineExerciseDto> list = routineService.getBucketExercise();
        routineDto.setUserId(userId);
        routineDto.setRoutineExercises(list);
        boolean isSuccess = routineService.addRoutine(routineDto);
        return "redirect:/routine.do?userId=" + userId;
    }
}
