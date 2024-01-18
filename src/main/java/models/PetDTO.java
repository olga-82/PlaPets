package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PetDTO {
    Type type;
    Gender Sex;
    String Breed;
    String color;
    String DistinctiveFeatures;
    String description;
    String location;
    String contactsPhone;
    String email;


}
