package fr.hermancia.exam.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Region implements EntityInterface {

    private Long id;

    private String name;

    private String code;



    @Override
    public Long getId() {
        return null;
    }
}
