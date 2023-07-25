package com.amazon.aws.developers.bedrock.util;

import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;

import software.amazon.awssdk.annotations.NotNull;

public class BedrockRequestBody {

    private BedrockRequestBody() {
    }

    public static BedrockRequestBodyBuilder builder() {
        return new BedrockRequestBodyBuilder();
    }

    public static class BedrockRequestBodyBuilder {

        @NotNull private String modelId;
        @NotNull private String prompt;
        private Map<String, Object> inferenceParameters;

        public BedrockRequestBodyBuilder withModelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        public BedrockRequestBodyBuilder withPrompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        public BedrockRequestBodyBuilder withInferenceParameter(String paramName, Object paramValue) {
            if (inferenceParameters == null) {
                inferenceParameters = new HashMap<>();
            }
            inferenceParameters.put(paramName, paramValue);
            return this;
        }

        public String build() {
            if (modelId == null) {
                throw new IllegalArgumentException("'modelId' is a required parameter");
            }
            if (prompt == null) {
                throw new IllegalArgumentException("'prompt' is a required parameter");
            }
            BedrockBodyCommand bedrockBodyCommand = null;
            switch (modelId) {
                case "amazon.titan-tg1-large":
                case "amazon.titan-text-express-v1":
                    bedrockBodyCommand = new AmazonTitanCommand(prompt, inferenceParameters);
                    break;
                case "ai21.j2-mid-v1":
                case "ai21.j2-ultra-v1":
                    bedrockBodyCommand = new AI21LabsCommand(prompt, inferenceParameters);
                    break;
                case "anthropic.claude-instant-v1":
                case "anthropic.claude-v1":
                case "anthropic.claude-v2":
                    bedrockBodyCommand = new AnthropicCommand(prompt, inferenceParameters);
                    break;
                case "cohere.command-text-v14":
                    bedrockBodyCommand = new CohereCommand(prompt, inferenceParameters);
                    break;
                case "stability.stable-diffusion-xl-v0":
                    bedrockBodyCommand = new StabilityAICommand(prompt, inferenceParameters);
                    break;
            }
            return bedrockBodyCommand.execute();
        }

    }

}

abstract class BedrockBodyCommand {

    protected String prompt;
    protected Map<String, Object> inferenceParameters;

    public BedrockBodyCommand(String prompt, Map<String, Object> inferenceParameters) {
        this.prompt = prompt;
        this.inferenceParameters = inferenceParameters;
    }

    protected void updateMap(Map<String, Object> existingMap, Map<String, Object> newEntries) {
        newEntries.forEach((newEntryKey, newEntryValue) -> {
            updateMap(existingMap, newEntryKey, newEntryValue);
        });
    }

    protected void updateMap(Map<String, Object> existingMap, String key, Object newValue) {
        if (existingMap.containsKey(key)) {
            existingMap.put(key, newValue);
        } else {
            existingMap.values().forEach(existingValue -> {
                if (existingValue instanceof Map) {
                    @SuppressWarnings("unchecked")
                    var valueAsMap = (Map<String, Object>) existingValue;
                    updateMap(valueAsMap, key, newValue);