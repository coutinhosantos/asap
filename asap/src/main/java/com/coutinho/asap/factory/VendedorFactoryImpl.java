package com.coutinho.asap.factory;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.coutinho.asap.contants.TIPO_CONTRATACAO;
import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.model.Filial;
import com.coutinho.asap.model.Vendedor;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class VendedorFactoryImpl implements VendedorFactory {
	
	@Override
	public Vendedor getVendedor(VendedorDTO vendedor, Long matricula, Filial filial) {
		return Vendedor.builder()
					   .id(vendedor.getId())	
					   .matricula(getMatricula(vendedor, matricula))
					   .nome(vendedor.getNome())
					   .dataNascimento(vendedor.getDataNascimento())
					   .cpfCnpj(vendedor.getCpfCnpj())
					   .email(vendedor.getEmail())
					   .tipoContratacao(getTipoContratacao(vendedor.getTipoContratacao()))
					   .filial(filial)
					   .build();
	}

	@Override
	public Vendedor getVendedor(VendedorDTO vendedor, Filial filial) {
		return Vendedor.builder()
					   .id(vendedor.getId())	
					   .matricula(vendedor.getMatricula())
					   .nome(vendedor.getNome())
					   .dataNascimento(vendedor.getDataNascimento())
					   .cpfCnpj(vendedor.getCpfCnpj())
					   .email(vendedor.getEmail())
					   .tipoContratacao(getTipoContratacao(vendedor.getTipoContratacao()))
					   .filial(filial)
					   .build();
	}
	
	private String getMatricula(VendedorDTO vendedor, Long matricula) {
		return String.valueOf(new DecimalFormat("00000000").format(matricula))
														   .concat("-")
														   .concat(getTipoContratacao(vendedor.getTipoContratacao()).getDescricao());
	}
	
	public TIPO_CONTRATACAO getTipoContratacao(String tipoContratacao) {
		if(tipoContratacao.equalsIgnoreCase(TIPO_CONTRATACAO.OUT.getDescricao())) {
            return TIPO_CONTRATACAO.OUT;
        }else if(tipoContratacao.equalsIgnoreCase(TIPO_CONTRATACAO.CLT.getDescricao())) {
            return TIPO_CONTRATACAO.CLT;
        }else if(tipoContratacao.equalsIgnoreCase(TIPO_CONTRATACAO.PJ.getDescricao())) {
            return TIPO_CONTRATACAO.PJ;
        }else {
            return null;
        }
	}
}
