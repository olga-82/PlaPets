package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class PetsPostDTO {

    String text;
    String description;
    String location;
    String contactsPhone;
    String email;
}
