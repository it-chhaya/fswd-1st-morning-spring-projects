package kh.edu.cstad.fswdmor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/student")
public class StudentController {

    //@RequestMapping(value = "/data", method = RequestMethod.GET)
    @GetMapping("/{stuId}/{ty}")
    public String viewStudent(@PathVariable("stuId") String studentId,
                              @PathVariable("ty") String type,
                              @RequestParam(required = false, defaultValue = "M") String gender,
                              ModelMap modelMap) {
        modelMap.addAttribute("data", studentId);
        modelMap.addAttribute("type", type);
        modelMap.addAttribute("gender", gender);
        return "student";
    }

}
