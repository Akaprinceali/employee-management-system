package com.tekpyramid.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int techId;
    private String techName;


}
