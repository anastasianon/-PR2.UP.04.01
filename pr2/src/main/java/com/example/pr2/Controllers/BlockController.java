package com.example.pr2.Controllers;

import com.example.pr2.Models.Post;
import com.example.pr2.Models.Prepod;
import com.example.pr2.Models.Student;
import com.example.pr2.repo.PostRepos;
import com.example.pr2.repo.PrepodRepos;
import com.example.pr2.repo.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlockController {
    @Autowired
    private PostRepos postRepos;

    @Autowired
    private PrepodRepos prepodRepos;

    @Autowired
    private StudentRepos studentRepos;

    @GetMapping("/")
    public String Main(Model model){
        return "Home";
    }

    @GetMapping("/block")
    public String GetBlog(Model model){
        Iterable<Post> posts = postRepos.findAll();
        model.addAttribute("posts", posts);
        return "block-main";

    }
    @GetMapping("/student")
    public String GetStudent(Model model){
        Iterable<Student> students = studentRepos.findAll();
        model.addAttribute("students",students);
        return "student-main";
    }
    @GetMapping("/prepod")
    public String GetPrepod(Model model){
        Iterable<Prepod> prepods = prepodRepos.findAll();
        model.addAttribute("prepods",prepods);
        return "prepod-main";
    }
    @GetMapping("/block/add")
    public String blogAdd(Model model){
        return "block-add";
    }
    @GetMapping("/student/add")
    public String studentAdd(Model model){
        return "student-add";
    }
    @GetMapping("/prepod/add")
    public String prepodAdd(Model model){
        return "prepod-add";
    }

    @PostMapping("/block/add")
    public String blogPostAdd(@RequestParam(value = "title") String title,
                              @RequestParam(value = "anons") String anons,
                              @RequestParam(value = "full_text") String full_text, Model model){
        Post post = new Post(title,anons,full_text);
        postRepos.save(post);
        return "redirect:/block";
    }
    @PostMapping("/student/add")
    public String studentPostAdd(@RequestParam(value = "Surname") String Surname,
                                 @RequestParam(value = "Name") String Name,
                                 @RequestParam(value = "MiddleName") String MiddleName,
                                 @RequestParam(value = "Group") String Groups,
                                 @RequestParam(value = "Birthday") String Birthday, Model model){
        Student student = new Student(Surname,Name,MiddleName,Groups,Birthday);
        studentRepos.save(student);
        return "redirect:/student";
    }
    @PostMapping("/prepod/add")
    public String prepodPostAdd(@RequestParam(value = "Surname") String Surname,
                                @RequestParam(value = "Name") String Name,
                                @RequestParam(value = "MiddleName") String MiddleName,
                                @RequestParam(value = "Predmets") String Predmets,
                                @RequestParam(value = "Grafic") String Grafic, Model model){
        Prepod prepod = new Prepod(Surname,Name,MiddleName,Predmets,Grafic);
        prepodRepos.save(prepod);
        return "redirect:/prepod";
    }
    @GetMapping("/block/filter")
    public String blogFilter(Model model){
        return "block-filter";
    }
    @GetMapping("/student/filter")
    public String studentFilter(Model model){
        return "student-filter";
    }
    @GetMapping("/prepod/filter")
    public String prepodFilter(Model model){
        return "prepod-filter";
    }

    @PostMapping("/block/filter/result")
    public String blogResult(@RequestParam String title, Model model){
        List<Post> result = postRepos.findByTitleContains(title);
        model.addAttribute("result", result);
        return "block-filter";
    }
    @PostMapping("/student/filter/result")
    public String studentResult(@RequestParam String surname, Model model){
        List<Student> result = studentRepos.findBysurnameContains(surname);
        model.addAttribute("result", result);
        return "student-filter";
    }
    @PostMapping("/prepod/filter/result")
    public String prepodResult(@RequestParam String surname, Model model){
        List<Prepod> result = prepodRepos.findBysurname(surname);
        model.addAttribute("result", result);
        return "prepod-filter";
    }

}
