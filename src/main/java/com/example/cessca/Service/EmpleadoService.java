package com.example.cessca.Service;

import com.example.cessca.Dto.EmpleadoDto;
import com.example.cessca.Dto.LoginDto;
import com.example.cessca.Response.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service

public interface EmpleadoService {
    String addEmpleado(EmpleadoDto empleadoDto);

    LoginResponse loginEmpleado(LoginDto loginDto);
}
