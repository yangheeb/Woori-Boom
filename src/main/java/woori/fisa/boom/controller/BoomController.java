package woori.fisa.boom.controller;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import woori.fisa.boom.service.BoomService;

@Controller
@RequestMapping("/boom")
public class BoomController {

    private static final String[] AVATAR_COLORS = {
        "#FF6B6B", "#4ECDC4", "#FFE66D", "#A8E6CF",
        "#FF8B94", "#7EC8E3", "#C3AED6", "#F9D56E"
    };

    private final BoomService boomService;

    public BoomController(BoomService boomService) {
        this.boomService = boomService;
    }

    @GetMapping("/")
    public String getPlayers(Model model) {
        model.addAttribute("players", boomService.findAllPlayers());
        model.addAttribute("avatarColors", AVATAR_COLORS);
        return "boom";
    }

    @PostMapping("/players")
    public String addPlayer(@RequestParam String name) {
        boomService.add(name);
        return "redirect:/boom/";
    }

    @PostMapping("/players/{id}/vote")
    public String vote(@PathVariable Long id, @RequestParam String direction) {
        boomService.vote(id, direction);
        return "redirect:/boom/";
    }

    @PostMapping("/players/reset")
    public String reset() {
        boomService.reset();
        return "redirect:/boom/";
    }
}
