package com.simple.radioservice.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("admin")
    public String demo() {
        return "admin/welcome";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/list";
    }

    @GetMapping("list")
    @ResponseBody
    public String list() {
        return "[{\"id\":24457,\"name\":\"triple-j\",\"signal\":\"105.7 FM\",\"title\":\"Triple J\",\"website\":\"https://www.abc.net.au/triplej/\",\"logo_url\":\"https://www.abc.net.au/triplej/\",\"tags\":\"news,life\",\"individual\":false,\"streams\":[{\"is_container\":true,\"media_type\":\"HTML\",\"mime\":\"text/html\",\"url\":\"https://www.abc.net.au/triplej/listen-live/player/\"},{\"is_container\":false,\"media_type\":\"MP3\",\"mime\":\"audio/mpeg\",\"url\":\"http://live-radio01.mediahubaustralia.com/2TJW/mp3/\"},{\"is_container\":true,\"media_type\":\"MP3\",\"mime\":\"audio/x-mpegurl\",\"url\":\"https://www.abc.net.au/res/streaming/audio/mp3/triplej.pls\"},{\"is_container\":true,\"media_type\":\"HLS\",\"mime\":\"application/x-mpegURL\",\"url\":\"https://abcradiolivehls-lh.akamaihd.net/i/triplejnsw_1@327300/master.m3u8\"}]}]";
    }

    @GetMapping("/login")
    public String login() {
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            return "redirect:/admin";
        }

        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
