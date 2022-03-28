package com.p1sun;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "tabela_testowa")
public class ExamEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private @Getter
    @Setter
    Long id;

    @Column(name = "kolumna1")
    private @Getter
    @Setter
    String col_1;

    @Column(name = "kolumna2")
    private @Getter
    @Setter
    String col_2;

    @Column(name = "kolumna3")
    private @Getter
    @Setter
    String col_3;

    @Column(name = "kolumna4")
    private @Getter
    @Setter
    Long col_4;
    
    public String __toString(){
        return String.format("{\"id\":\"%d\",\"col_1\":\"%s\",\"col_2\":\"%s\",\"col_3\":\"%s\",\"col_4\":\"%d\"}", id, col_1, col_2, col_3, col_4);
    }
}
