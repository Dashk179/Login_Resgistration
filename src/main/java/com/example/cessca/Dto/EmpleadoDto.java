package com.example.cessca.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmpleadoDto {

    private int empleadoId;
    private String name;
    private String email;
    private String password;

}
