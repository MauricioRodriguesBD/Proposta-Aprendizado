package zup.aprendizado.proposta.criarproposta;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/*
 * Uma proposta deve conter
 * CPF/CNPJ -> Deve ser válido
 * E-Mail -> Não pode ser vazio, nulo ou inválido
 * Nome -> não pode ser vazio ou nulo
 * Endereço -> Não pode ser vazio ou nulo
 * Salário -> Não pode ser vazio, nulo ou negativo
 */

public class PropostaRequest {
	
	@NotNull
	@Column(nullable = false)
	private String documento;

	@Email
	@NotNull
	@Column(nullable = false)
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@NotBlank
	@Column(nullable = false)
	private String endereco;

	@NotNull
	@PositiveOrZero
	@Column(nullable = false)
	private BigDecimal salario;

	public PropostaRequest(String documento, @Email @NotNull String email, @NotBlank String nome, @NotBlank String endereco,
			@NotNull @PositiveOrZero BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	// Apenas Getters Até o momento, colocarei todos os Getters com o intuito de
	// observar o que ele retorna

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	//
	public Proposta toModel() {

		return new Proposta(documento, email, nome, endereco, salario);
	}

}
