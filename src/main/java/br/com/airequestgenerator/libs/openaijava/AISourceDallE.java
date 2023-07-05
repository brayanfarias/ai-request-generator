package br.com.airequestgenerator.libs.openaijava;

import br.com.airequestgenerator.core.domain.RequestInput;
import br.com.airequestgenerator.core.domain.RequestOutput;
import br.com.airequestgenerator.core.useCase.request.AISource;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

public record AISourceDallE(String token) implements AISource {

    @Override
    public RequestOutput request(RequestInput input) {
        OpenAiService service = new OpenAiService(token(), Duration.ofSeconds(30));

        CreateImageRequest createImageRequest = CreateImageRequest.builder()
                .prompt(input.prompt())
                .n(1)
                .size("512x512")
                .build();

        List<Image> images = service.createImage(createImageRequest).getData();

        return new RequestOutput(images.get(0).getUrl());
    }
}
