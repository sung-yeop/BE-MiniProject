package demo.controller;

import ch.qos.logback.core.model.Model;
import demo.dto.ExerciseDto;
import demo.dto.UserProfileDto;
import demo.service.exercise.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/exercise.do")
    public ModelAndView homeExercise(@RequestParam ("userId") Long userId){
        ModelAndView mv = new ModelAndView("/exercise/exerciseList");
        List<ExerciseDto> list = exerciseService.getUserExercise(userId);
        mv.addObject("list", list);
        mv.addObject("userId", userId);
        return mv;
    }

    @PostMapping("/exercise/add")
    public String addExercise(ExerciseDto exerciseDto){
        boolean isSuccess = exerciseService.addExercise(exerciseDto);
        if(isSuccess){
            return "redirect:/exercise.do?userId=" + exerciseDto.getUserId();
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/exerciseUpdate.do")
    public ModelAndView viewExerciseUpdate(@RequestParam ("exerciseId") Long exerciseId){
        ModelAndView mv = new ModelAndView("/exercise/exerciseUpdate");
        ExerciseDto exerciseDto = exerciseService.getExercise(exerciseId);
        mv.addObject("exerciseDto", exerciseDto);
        return mv;
    }

    @PostMapping("/exercise/delete")
    public String deleteExercise(@RequestParam ("exerciseId") Long exerciseId){
        boolean isSuccess = exerciseService.deleteExercise(exerciseId);
        ExerciseDto exerciseDto = exerciseService.getExercise(exerciseId);
        if(isSuccess){
            return "redirect:/exercise.do?userId=" + exerciseDto.getUserId();
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/exercise/update")
    public String updateExercise(ExerciseDto exerciseDto, RedirectAttributes redirectAttributes){
        boolean isSuccess = exerciseService.updateExercise(exerciseDto);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("success", "운동이 정상적으로 변경되었습니다.\n[목록으로 돌아가기]");
            return "redirect:/exerciseUpdate.do?exerciseId=" + exerciseDto.getId();
        } else {
            redirectAttributes.addFlashAttribute("fail", "[DB Error]");
            return "redirect:/";
        }
    }
}
