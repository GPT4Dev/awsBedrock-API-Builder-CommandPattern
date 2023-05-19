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
                throw new IllegalArgumentException("'prompt' is a 