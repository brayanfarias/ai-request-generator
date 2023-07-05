package br.com.airequestgenerator.core.useCase.request;

import br.com.airequestgenerator.core.domain.RequestInput;
import br.com.airequestgenerator.core.domain.RequestOutput;

public interface AISource {
    RequestOutput request(RequestInput input);

}
