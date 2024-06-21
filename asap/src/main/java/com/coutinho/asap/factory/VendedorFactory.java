package com.coutinho.asap.factory;

import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.model.Filial;
import com.coutinho.asap.model.Vendedor;

public interface VendedorFactory {
	Vendedor getVendedor(VendedorDTO vendedor, Long matricula, Filial filial);
	Vendedor getVendedor(VendedorDTO vendedor, Filial filial);
}
