package zup.aprendizado.proposta.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zup.aprendizado.proposta.criarproposta.Proposta;
import zup.aprendizado.proposta.criarproposta.PropostaRepository;
import zup.aprendizado.proposta.criarproposta.PropostaRequest;
/*
 * Esse Validador tem como objetivo buscar no banco um documento
 * Caso exista, ele retornará false
 * Caso não exista, retornará true
 */

@Component
public class DocumentosIguaisValidador {

	
		@Autowired
		private PropostaRepository repository;
		
		public boolean isValid(PropostaRequest request) {
			Optional<Proposta> procura = repository.findByDocumento(request.getDocumento());
			if(procura.isPresent()) {
				return false;
			}
			return true;
		}
}
