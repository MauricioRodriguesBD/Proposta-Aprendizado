package zup.aprendizado.proposta.criarproposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import zup.aprendizado.proposta.validacao.CpfOrCnpj;

/*
 * Uma proposta deve conter
 * CPF/CNPJ -> Deve ser válido
 * E-Mail -> Não pode ser vazio, nulo inválido
 * Nome -> não pode ser vazio ou nulo
 * Endereço -> Não pode ser vazio ou nulo
 * Salário -> Não pode ser vazio, nulo ou negativo
 */ 

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CpfOrCnpj
	private String documento;

	private String email;

	private String nome;

	private String endereco;

	private BigDecimal salario;
	
	//Proibe construtor vazio
	@Deprecated
	private Proposta() {}

	// Construtor sem Id já que ele será gerado automaticamente

	public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	// Apenas Getters Até o momento, colocarei todos os Getters com o intuito de
	// observar o que ele retorna

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

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

}
