package az.edu.itbrains.bloggg130.controllers.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(){
        return "/dashboard/index.html";
    }
}
