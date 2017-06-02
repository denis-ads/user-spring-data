package br.com.developer.domain.model;

/**
 *
 * @author denis
 *
 */
public class Paginacao {

    private Integer numeroPagina;
    private Integer quantidadeTotal;

    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(final Integer numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(final Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

}
