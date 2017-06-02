package br.com.developer.domain.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ResponseDefault implements Serializable {

    private static final long serialVersionUID = 7602083668945278735L;

    // Número único que deve ser utilizado para relacionar o retorno a log esse
    // número deve ser gerado seguindo o padrão UUID
    private String correlationId;

    // numero de telefone residencial com DDD sem mascara
    private HttpStatus statusCode;

    // numero de telefone residencial com DDD sem mascara
    private String mensagem;
    
	public ResponseDefault() {
		super();
	}

    public ResponseDefault(String correlationId, HttpStatus statusCode, String mensagem) {
		super();
		this.correlationId = correlationId;
		this.statusCode = statusCode;
		this.mensagem = mensagem;
	}

	public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(final String correlationId) {
        this.correlationId = correlationId;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ResponseDefault [correlationId=");
        builder.append(correlationId);
        builder.append(", statusCode=");
        builder.append(statusCode);
        builder.append(", mensagem=");
        builder.append(mensagem);
        builder.append("]");
        return builder.toString();
    }

}
