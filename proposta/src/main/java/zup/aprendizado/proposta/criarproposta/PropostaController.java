package zup.aprendizado.proposta.criarproposta;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import zup.aprendizado.proposta.validacao.DocumentosIguaisValidador;

/*
 * A proposta deve estar armazenada no sistema, com um identificador gerado pelo sistema.
 * Retornar 201 com Header Location preenchido com a URL da nova proposta em caso de sucesso.
 * Retornar 400 quando violado alguma das restrições.
 */

@RestController
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaRepository repository;

	@Autowired
	private DocumentosIguaisValidador documentosIguaisValidador;

	// Método que criará uma proposta e persistirá no banco.

	@PostMapping
	@Transactional
	public ResponseEntity<?> criarProposta(@Valid @RequestBody PropostaRequest request, UriComponentsBuilder builder) {

		// Verifica se estão criando uma proposta com o mesmo documento, se tiver,
		// retorna status 422(UNPROCESSABLE_ENTITY)
		if (!documentosIguaisValidador.isValid(request)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		// instancia proposta e utiliza o método criado em PropostaRequest para pegar os
		// dados
		Proposta proposta = request.toModel();
		// salva e persiste no banco pelo Spring Data
		repository.save(proposta);
		// vai até o caminho criado e construirá a partir do ID gerado
		URI uri = builder.path("/proposta").build(proposta.getId());
		/*
		 * retornará status 201(Created), o created necessita que seja passado uma URI
		 * LOCATION, no caso a uri que acabara de ser instanciado.
		 */
		// estou usando body para ver se o que está sendo criado terá um retorno.
		return ResponseEntity.created(uri).body(proposta);

	}
}
