package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.entity.HardRiddle;

import com.springboot.entity.MediumRiddle;
import com.springboot.entity.Riddle;
import com.springboot.service.HardService;
import com.springboot.service.MidiumService;
import com.springboot.service.RiddleSerivice;

@Controller
public class HomeController {
    
    @Autowired
    private RiddleSerivice service;
    @Autowired
    private MidiumService mService;
    @Autowired
    private HardService hService;
    

    

    private int point = 0;
    private int highScore = 0;

    private List<Long> shownRiddles = new ArrayList<>(); 

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/game")
    public String showRiddleGame(@RequestParam int level, Model model) {
        if (level == 1) {
            List<Riddle> allRiddles = service.getAll();
            List<Riddle> availableRiddles = new ArrayList<>();

            for (Riddle r : allRiddles) {
                if (!shownRiddles.contains(r.getId())) {
                    availableRiddles.add(r);
                }
            }

            if (availableRiddles.isEmpty()) {
                model.addAttribute("message", "🎉 All riddles completed!");
                model.addAttribute("point", point);
                model.addAttribute("highScore", highScore);
                return "result"; 
            }

            Riddle riddle = availableRiddles.get(new Random().nextInt(availableRiddles.size()));
            shownRiddles.add(riddle.getId());

            model.addAttribute("riddle", riddle);
            model.addAttribute("level", riddle.getLevel());
        }
        
       if(level==2) {
    	   List<MediumRiddle> allRiddles = mService.getAllRiddle();
           List<MediumRiddle> availableRiddles = new ArrayList<>();

           for (MediumRiddle r : allRiddles) {
               if (!shownRiddles.contains(r.getId())) {
                   availableRiddles.add(r);
               }
           }

           if (availableRiddles.isEmpty()) {
               model.addAttribute("message", "🎉 All riddles completed!");
               model.addAttribute("point", point);
               model.addAttribute("highScore", highScore);
               return "result"; 
           }

           MediumRiddle riddle = availableRiddles.get(new Random().nextInt(availableRiddles.size()));
           shownRiddles.add(riddle.getId());

           model.addAttribute("riddle", riddle);
           model.addAttribute("level", riddle.getLevel());
       } 
       
       if(level==3) {
    	   List<HardRiddle> allRiddles = hService.getAllRiddle();
           List<HardRiddle> availableRiddles = new ArrayList<>();

           for (HardRiddle r : allRiddles) {
               if (!shownRiddles.contains(r.getId())) {
                   availableRiddles.add(r);
               }
           }

           if (availableRiddles.isEmpty()) {
               model.addAttribute("message", "🎉 All riddles completed!");
               model.addAttribute("point", point);
               model.addAttribute("highScore", highScore);
               return "result"; 
           }

           HardRiddle riddle = availableRiddles.get(new Random().nextInt(availableRiddles.size()));
           shownRiddles.add(riddle.getId());

           model.addAttribute("riddle", riddle);
           model.addAttribute("level", riddle.getLevel());
       }
        model.addAttribute("point", point);
        model.addAttribute("highScore", highScore);
        return "game";
    }

    @PostMapping("/check")
    public String checkAnswer(@RequestParam String userAnswer,@RequestParam int level, @RequestParam Long riddleId,
    		                                       RedirectAttributes redirectAttributes) {
                              
                               
    	if(level ==1) {
        Riddle riddle = service.getById(riddleId);
         boolean correct = riddle.getAnswer().trim().equalsIgnoreCase(userAnswer.trim());
         if (correct) {
             point++;
         }
         if (point > highScore) {
             highScore = point;
         }

         redirectAttributes.addFlashAttribute("result", correct ? "Correct! 👏" : "Wrong Answer 😢 - Correct Answer is: " + riddle.getAnswer());
         redirectAttributes.addFlashAttribute("point", point);
         redirectAttributes.addFlashAttribute("highScore", highScore);

         return "redirect:/game?level=" + riddle.getLevel();
    	}
    	else if(level==2) {
    		MediumRiddle riddle = mService.getRiddleById(riddleId);
    		 boolean correct = riddle.getAnswer().trim().equalsIgnoreCase(userAnswer.trim());
    		 if (correct) {
    	            point++;
    	        }
    		 if (point > highScore) {
    	            highScore = point;
    	        }

    	        redirectAttributes.addFlashAttribute("result", correct ? "Correct! 👏" : "Wrong Answer 😢 - Correct Answer is: " + riddle.getAnswer());
    	        redirectAttributes.addFlashAttribute("point", point);
    	        redirectAttributes.addFlashAttribute("highScore", highScore);

    	        return "redirect:/game?level=" + riddle.getLevel();
    	}
    	else if(level==3) {
    	   HardRiddle riddle=hService.getById(riddleId);
    	   boolean correct = riddle.getAnswer().trim().equalsIgnoreCase(userAnswer.trim());
    	   if (correct) {
               point++;
           }
    	   if (point > highScore) {
               highScore = point;
           }

           redirectAttributes.addFlashAttribute("result", correct ? "Correct! 👏" : "Wrong Answer 😢 - Correct Answer is: " + riddle.getAnswer());
           redirectAttributes.addFlashAttribute("point", point);
           redirectAttributes.addFlashAttribute("highScore", highScore);

           return "redirect:/game?level=" + riddle.getLevel();
       }

    	else return "error";
    }

    @GetMapping("/reset")
    public String resetGame() {
        point = 0;
        shownRiddles.clear();
        return "redirect:/";
    }
}
