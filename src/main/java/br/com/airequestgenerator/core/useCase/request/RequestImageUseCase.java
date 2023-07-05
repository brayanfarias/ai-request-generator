package br.com.airequestgenerator.core.useCase.request;

import br.com.airequestgenerator.core.domain.RequestInput;
import br.com.airequestgenerator.core.domain.RequestOutput;

public class RequestImageUseCase {

    private final AISource source;

    public RequestImageUseCase(AISource source) {
        this.source = source;
    }

    public RequestOutput execute(RequestInput input) {
        return source.request(input);
    }

}
