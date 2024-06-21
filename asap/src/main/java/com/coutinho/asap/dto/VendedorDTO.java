package com.coutinho.asap.dto;

import com.coutinho.asap.annotation.CpfCnpj;
import com.coutinho.asap.annotation.TipoContratacao;
import com.coutinho.asap.annotation.TipoDocumento;
import com.coutinho.asap.annotation.ValidDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@TipoDocumento
public class VendedorDTO {
	
    private String id;
    
    private String matricula;

    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    
    @ValidDate
    private String dataNascimento;
    
    @NotNull(message = "O cpfCnpj não pode ser nulo")
    @CpfCnpj
    private String cpfCnpj;
    
    @Email(message = "Email deve ser válido")
    private String email;
    
    @NotNull(message = "O Tipo de Contratacao não pode ser nulo")
    @TipoContratacao
    private String tipoContratacao;

	public String getCpfCnpj() {
		return cpfCnpj.replace(".", "").replace("-", "").replace("/", "");
	}
}
