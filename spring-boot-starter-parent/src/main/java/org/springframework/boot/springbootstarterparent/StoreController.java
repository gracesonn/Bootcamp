package org.springframework.boot.springbootstarterparent;



@Controller
@EnableAutoConfiguration
public static class StoreController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}