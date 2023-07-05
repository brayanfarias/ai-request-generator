package br.com.airequestgenerator.framework.adapters;

import br.com.airequestgenerator.core.domain.RequestInput;
import br.com.airequestgenerator.core.domain.RequestOutput;
import br.com.airequestgenerator.core.useCase.request.AISource;
import br.com.airequestgenerator.libs.openaijava.AISourceDallE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AISourceDallEAdapter implements AISource {


    private final String token;

    public AISourceDallEAdapter(@Value("${spring.env.vars.token}") String token) {
        this.token = token;
    }


    @Override
    public RequestOutput request(RequestInput input) {
        AISourceDallE aISourceDallE = new AISourceDallE(token);
        return aISourceDallE.request(input);
    }
}
