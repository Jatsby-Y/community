package life.coder.community.controller;

import life.coder.community.dto.PaginationDTO;
import life.coder.community.mapper.UserMapper;
import life.coder.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PaginationDTO paginations = questionService.list(page, size);
        model.addAttribute("pagination", paginations);
        return "index";
    }
}
