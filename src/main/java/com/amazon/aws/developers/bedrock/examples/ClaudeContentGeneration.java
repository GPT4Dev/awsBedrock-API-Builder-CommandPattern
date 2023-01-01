package com.amazon.aws.developers.bedrock.examples;

import java.nio.charset.Charset;
import org.json.JSONObject;
import com.amazon.aws.developers.bedrock.util.BedrockRequestBody;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bed