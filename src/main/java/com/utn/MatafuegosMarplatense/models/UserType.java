package com.utn.MatafuegosMarplatense.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_type")

public class UserType {
    @Id
    @Column(name = "id_user_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserType;

    @Column(name = "usertype_name")
    @NotNull
    private String userTypeName;
}
