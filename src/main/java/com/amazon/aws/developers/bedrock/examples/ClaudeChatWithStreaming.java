package com.amazon.aws.developers.bedrock.examples;

import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

import org.json.JSONObject;

import com.amazon.aws.developers.bedrock.util.BedrockRequestBody;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeAsyncClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelWithResponseStreamRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelWithResponseStreamResponseHandler;
import software.amazon.awssdk.services.bedrockruntime.model.PayloadPart;

public class ClaudeChatWithStreaming {

    private static final String MODEL_ID = "anthropic.claude-v2";

    private static final String PROMPT = """
        Generative AI refers to artificial intelligence systems that are capable of generating
        novel content such as text, images, audio, video, and more, as opposed to just analyzing
        existing data. The key aspect of generative AI is that it creates brand new outputs that
        are unique and original, not just reproductions or remixes of existing content. Generative
     