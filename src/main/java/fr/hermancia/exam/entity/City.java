package fr.hermancia.exam.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City implements EntityInterface{




    private Long id;

    private String name;

    private Department department;

    private PostalCode postalcode;

    private String siren;

    private int population;

    private String code;


}
