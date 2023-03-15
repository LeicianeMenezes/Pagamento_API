package uea.pagamentos_api.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uea.pagamentos_api.models.enums.TipoLancamento;

public class Lancamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigo;
	@NotBlank(message = "Descrição é obrigatório")
	private String descrição;
	@NotNull(message = "Data vencimento é obrigatório")
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	@NotNull(message = "Valor é obrigatório")
	private BigDecimal valor;
	private String observação;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Tipo é obrigatório")
	private TipoLancamento tipoLancamento;
	
	@NotBlank(message = "Categoria é obrigatório")
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private Categoria categoria;
	
	@JsonIgnoreProperties({"endereco","ativo"})
	@NotNull(message = "Pessoa é obrigatório")
	@ManyToOne
	@JoinColumn(name="codigo_pessoa")
	private Pessoa pessoa;
	
	
	public Lancamento() {
		super();
	}

	public Lancamento(Long codigo, String descrição, LocalDate dataVencimento, LocalDate dataPagamento,
			BigDecimal valor, String observação, TipoLancamento tipoLancamento, Categoria categoria, Pessoa pessoa) {
		super();
		this.codigo = codigo;
		this.descrição = descrição;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.observação = observação;
		this.tipoLancamento = tipoLancamento;
		this.categoria = categoria;
		this.pessoa = pessoa;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservação() {
		return observação;
	}

	public void setObservação(String observação) {
		this.observação = observação;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	


}
