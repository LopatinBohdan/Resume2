package com.example.resume2.Controllers;


import com.example.resume2.Models.Degree;
import com.example.resume2.Repo.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DegreeController {
    @Autowired
    public DegreeRepository degreeRepository;

    @GetMapping("/degrees/degrees")
    public String getDegrees(Model model){
        Iterable<Degree> degrees= degreeRepository.findAll();
        model.addAttribute("degrees", degrees);
        return "/degrees/degrees";
    }

    @GetMapping("/degrees/addDegree")
    public String addDegreeForm(@RequestParam(name = "id", required = false)Long id, Model model){
//        if(degreeRepository.existsById(id)){
//            Degree degree=degreeRepository.findById(id).get();
//            model.addAttribute("degree", degree);
//        }
//        else{
//            model.addAttribute("degree", new Degree());
//        }
        return "/degrees/addDegree";
    }
    @PostMapping("/degrees/addDegree")
    public String addDegree(@ModelAttribute("degree") Degree degree){
        if(degree.getId()!=null){
            Degree temp=degree;
            degreeRepository.save(temp);
        }
        else{
            degreeRepository.save(degree);
        }
        return "redirect:/degrees/degrees";
    }

    @GetMapping("/degrees/{id}/infoDegree")
    public String infoDegree(@PathVariable(value = "id")Long id, Model model){
        if(!degreeRepository.existsById(id)){
            return "redirect:/degrees/degrees";
        }
        else{
            Degree degree=degreeRepository.findById(id).get();
            model.addAttribute("degree",degree);
            return "/degrees/infoDegree";
        }
    }
    @GetMapping("/degrees/{id}/deleteDegree")
    public String deleteDegree(@PathVariable(value = "id") Long id, Model model){
        Degree degree=degreeRepository.findById(id).get();
        degreeRepository.delete(degree);
        return "redirect:/apartments/apartments";
    }
}
