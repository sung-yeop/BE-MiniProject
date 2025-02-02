package demo.controller;

import demo.dto.UserProfileDto;
import demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired()
    private UserService userService;

    @GetMapping("/")
    public ModelAndView userSelect() {
        ModelAndView modelAndView = new ModelAndView("/user/userList");
        List<UserProfileDto> list = userService.getAllUsers();
        return modelAndView.addObject("list", list);
    }

    @GetMapping("/userAdd.do")
    public String goToUserAdd() {
        return "/user/userAdd";
    }

    @PostMapping("/user/add")
    public String addUser(UserProfileDto userProfileDto, RedirectAttributes redirectAttributes) {
        Boolean isSuccess = userService.addUser(userProfileDto);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("success", "사용자가 성공적으로 등록되었습니다.\n(메인으로 돌아가기)");
            return "redirect:/userAdd.do";
        } else {
            redirectAttributes.addFlashAttribute("fail", "사용자 등록에 실패했습니다.\n[DB Error]");
            return "redirect:/userAdd.do";
        }
    }

    @GetMapping("/userUpdate.do")
    public ModelAndView openUserDetail(@RequestParam("userId") Long userId) {
        ModelAndView modelAndView = new ModelAndView("/user/userUpdate");
        UserProfileDto userProfileDto = userService.selectUserDetail(userId);
        modelAndView.addObject("userProfileDto", userProfileDto);
        return modelAndView;
    }

    @PostMapping("/user/update")
    public String updateUser(UserProfileDto userProfileDto, RedirectAttributes redirectAttributes) {
        Boolean isSuccess = userService.updateUser(userProfileDto);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("success", "사용자가 성공적으로 수정되었습니다.\n(메인으로 돌아가기)");
            return "redirect:/userUpdate.do?userId=" + userProfileDto.getId().toString();
        } else {
            redirectAttributes.addFlashAttribute("fail", "사용자 수정에 실패했습니다.\n[DB Error]");
            return "redirect:/userUpdate.do?userId=" + userProfileDto.getId().toString();
        }
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam("userId") Long userId, RedirectAttributes redirectAttributes) {
        Boolean isSuccess = userService.deleteUser(userId);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("success", "사용자가 성공적으로 삭제되었습니다.");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("fail", "[DB Error]");
            return "redirect:/";
        }
    }
}
