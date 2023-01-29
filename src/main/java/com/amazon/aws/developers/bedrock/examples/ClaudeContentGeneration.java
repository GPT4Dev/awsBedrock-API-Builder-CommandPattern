package com.amazon.aws.developers.bedrock.examples;

import java.nio.charset.Charset;
import org.json.JSONObject;
import com.amazon.aws.developers.bedrock.util.BedrockRequestBody;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;

public class ClaudeContentGeneration {

    private static final String MODEL_ID = "anthropic.claude-v2";

    private static final String PROMPT = """
        Generative AI refers to artificial intelligence systems that are capable of generating
        novel content such as text, images, audio, video, and more, as opposed to just analyzing
        existing data. The key aspect of generative AI is that it creates brand new o