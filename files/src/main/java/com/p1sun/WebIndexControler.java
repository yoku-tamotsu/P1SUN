
package com.p1sun;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class WebIndexControler {
    
    @GetMapping("/")
    public String webIndex(Model model) {
        
        ArrayList<String> columnsNames = new ArrayList<>();
        columnsNames.add("id");
        columnsNames.add("kolumna1");
        columnsNames.add("kolumna2");
        columnsNames.add("kolumna3");
        columnsNames.add("kolumna4");
        
        model.addAttribute("columnsNames", columnsNames);
        
        return "index";
    }

}
