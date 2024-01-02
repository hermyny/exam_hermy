package fr.hermancia.exam.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department implements EntityInterface{

    private Long id;

    private Region region;

    private String name;

    private String code;


    @Override
    public Long getId() {
        return null;
    }
}
