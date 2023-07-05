package br.com.airequestgenerator.framework.entrypoint;

import br.com.airequestgenerator.core.domain.RequestInput;
import br.com.airequestgenerator.core.domain.RequestOutput;
import br.com.airequestgenerator.core.useCase.request.AISource;
import br.com.airequestgenerator.core.useCase.request.RequestImageUseCase;
import br.com.airequestgenerator.framework.entrypoint.dto.RequestInDto;
import br.com.airequestgenerator.framework.entrypoint.dto.RequestOutDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class GeneratorController {

    private final AISource aiSourceDallEAdapter;

    public GeneratorController(AISource aiSourceDallEAdapter) {
        this.aiSourceDallEAdapter = aiSourceDallEAdapter;
    }

    @PostMapping("/generate")
    public RequestOutDto getImage(@RequestBody RequestInDto requestInDto) {
        RequestImageUseCase useCase = new RequestImageUseCase(aiSourceDallEAdapter);
        RequestOutput output = useCase.execute(new RequestInput(requestInDto.prompt()));
        return new RequestOutDto(output);

    }
}
