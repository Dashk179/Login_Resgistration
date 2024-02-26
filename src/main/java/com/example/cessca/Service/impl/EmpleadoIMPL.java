package com.example.cessca.Service.impl;

import com.example.cessca.Dto.EmpleadoDto;
import com.example.cessca.Dto.LoginDto;
import com.example.cessca.Entity.Empleado;
import com.example.cessca.Repository.EmpleadoRepository;
import com.example.cessca.Response.LoginResponse;
import com.example.cessca.Service.EmpleadoService;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor

public class EmpleadoIMPL implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    private final  PasswordEncoder passwordEncoder;

    @Override
    public String addEmpleado(EmpleadoDto empleadoDto) {

        Empleado empleado = new Empleado(
                empleadoDto.getEmpleadoId(),
                empleadoDto.getName(),
                empleadoDto.getEmail(),

                this.passwordEncoder.encode(empleadoDto.getPassword())
        );
        empleadoRepository.save(empleado);
        return empleado.getName();
    }

    @Override
    public LoginResponse loginEmpleado(LoginDto loginDto) {
        // Buscar empleado por correo electrónico
        Empleado empleado = empleadoRepository.findByEmail(loginDto.getEmail());

        // Verificar si el empleado existe
        if (empleado != null) {
            // Comparar la contraseña proporcionada con la contraseña almacenada
            if (passwordEncoder.matches(loginDto.getPassword(), empleado.getPassword())) {
                // Las contraseñas coinciden, inicio de sesión exitoso
                return new LoginResponse("Inicio de sesión satisfactorio", true);
            } else {
                // La contraseña no coincide, inicio de sesión fallido
                return new LoginResponse("Verifique su contraseña", false);
            }
        } else {
            // El empleado no existe en la base de datos
            return new LoginResponse("El email proporcionado no está registrado", false);
        }
    }


}
