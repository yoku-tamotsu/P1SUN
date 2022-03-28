package com.p1sun;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/examentities")
public class ExamEntityController {
    
    private final String queryTemplate = "SELECT DISTINCT * FROM tabela_testowa WHERE :column IN ( SELECT :column FROM (SELECT :column, count(*) FROM tabela_testowa GROUP BY :column HAVING count(*) :mode 1) AS res)";

    @Autowired
    private EntityManager entityManager;

    

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{mode}/{columnName}", produces="plain/text")
    public String getDuplicates(@PathVariable("mode") String mode, @PathVariable("columnName") String columnName) {
        String m = mode.equals("duplicates") ? ">" : (mode.equals("singels") ? "=" : null);
        
        if(m == null){
            System.out.println("---> unrecognized mode: " + mode);
            return null;
        }
        
        String queryString = queryTemplate.replace(":column", columnName).replace(":mode", m);
        Query query = entityManager.createNativeQuery(queryString, ExamEntity.class);
        List<ExamEntity> list = query.getResultList();

        printInfo(mode, columnName, list.size());

        return listToJSON(list);
    }
    
    private String listToJSON(List<ExamEntity> list){
        ArrayList<String> als = new ArrayList<>();
        
        for(ExamEntity ee : list){
            als.add(ee.__toString());
        }
        
        return String.format("[%s]", String.join(",", als));
    }
    
    private void printInfo(String type, String columnName, int size){
        System.out.println("---> get " + type + " by column: '" + columnName + "' ---> found entities: " + size);
    }
}
