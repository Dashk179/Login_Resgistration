package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.EmpleadoDto;
import com.example.cessca.Dto.LoginDto;
import com.example.cessca.Response.LoginResponse;
import com.example.cessca.Service.EmpleadoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "cessca/v1/empleado")
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    public  EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @PostMapping(path = "/save")
    public String saveEmpleado(@RequestBody EmpleadoDto empeadoDto){
        String id = empleadoService.addEmpleado(empeadoDto);
        return id;
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> loginEmpleado(@RequestBody LoginDto loginDto) {
        // Lógica para manejar la solicitud de inicio de sesión
        LoginResponse loginResponse = empleadoService.loginEmpleado(loginDto);
        // Retorna una respuesta con el código de estado OK y el objeto LoginResponse en el cuerpo
        return ResponseEntity.ok(loginResponse);
    }
}
