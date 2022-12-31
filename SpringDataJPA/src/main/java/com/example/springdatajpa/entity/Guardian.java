package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
//cannot be an entity, since its composed in the student instead it is embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
    @AttributeOverride(
            name= "name",
            column = @Column(name = "guardian_name")
    ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name ="mobile",
                column = @Column(name = "guardian_mobile")
        )
 // here for the attribute overrides, since our student has the guardian details already
 //in the table, we have to override it here, so it doesn't duplicate its name values on the table
}

)
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
