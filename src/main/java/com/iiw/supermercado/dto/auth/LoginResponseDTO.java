package com.iiw.supermercado.dto.auth;

public record LoginResponseDTO(
    String token,
    String type
){
}
