package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O Atributo Nome é obrigatório")
	@Size(min = 2, max = 100, message = "O Atributo Nome de conter no mínimo 2 e no maximo 100 caracteres")
	private String nome;

	@NotNull(message = "O Atributo Descrição é obrigatório")
	@Size(min = 10, max = 100, message = "O Atributo Descrição de conter no mínimo 10 e no maximo 100 caracteres")
	private String descricao;
	
	@NotNull(message = "O Atributo Quantidade é obrigatório")
    private Integer quantidade;

    @NotNull(message = "O atributo Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser no mínimo R$ 0,01")
    @DecimalMax(value = "20000.00", message = "O preço deve ser no máximo R$ 20.000,00")
    @Positive(message = "O preço deve ser um valor positivo")
    private BigDecimal preco;
    
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
    
    
}