package fr.hermancia.exam.entity.digimon;


import fr.hermancia.exam.entity.EntityInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Digimon implements EntityInterface {

private Long id;

private String name;

private String img;

private String level;




    @Override
    public Long getId() {
        return null;
    }
}
