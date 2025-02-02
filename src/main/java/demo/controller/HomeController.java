package demo.controller;

import demo.dto.ExerciseDto;
import demo.dto.RoutineDto;
import demo.dto.UserProfileDto;
import demo.service.exercise.ExerciseService;
import demo.service.routine.RoutineService;
import demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private RoutineService routineService;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("userId") Long userId) {
        ModelAndView mv = new ModelAndView("/home/home");
        UserProfileDto userProfileDto = userService.selectUserDetail(userId);
        List<ExerciseDto> exerciseList = exerciseService.getUserExercise(userId);
        List<RoutineDto> routineList = routineService.getRoutineList(userId);
        mv.addObject("exerciseList", exerciseList);
        mv.addObject("userProfileDto", userProfileDto);
        mv.addObject("routineList", routineList);
        return mv;
    }
}
