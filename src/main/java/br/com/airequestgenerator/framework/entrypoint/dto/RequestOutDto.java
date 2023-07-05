package br.com.airequestgenerator.framework.entrypoint.dto;

import br.com.airequestgenerator.core.domain.RequestOutput;

public class RequestOutDto {

    public String url;

    public RequestOutDto(RequestOutput requestOutput) {
        this.url = requestOutput.url();
    }
}
