# Amazon Bedrock API with Builder and Command Patterns

[Amazon Bedrock](https://aws.amazon.com/bedrock) offers choice of high-performing foundation models from leading AI companies like AI21 Labs, Anthropic, Cohere, Stability AI, and Amazon through a single API. Despite the uniform API, each foundation model has its unique schema, making API interactions complex for developers.

For instance, let's consider the prompt: `When Christmas is celebrated?`

Making API requests to Amazon Bedrock using different foundation models would require distinct body payloads.

This project offers a simple yet powerful implementation to efficiently handle such API interactions. It utilizes the [Builder design pattern](https://en.wikipedia.org/wiki/Builder_pattern) and the [Command design pattern](https://en.wikipedia.org/wiki/Command_pattern) to streamline the creation of body payloads. You can learn about using the code from the YouTube video below.

[![Amazon Bedrock with Java](images/youtube.png)](https://www.youtube.com/watch?v=Vv2J8N0-eHc)

## Usage of BedrockRequestBody implementation

BedrockRequestBody implementation provides a simple way to create the body payloads without having to manually write them down. Here's how you can use it:

```java
String bedrockBody = BedrockRequestBody.builder()
   .withModelId("ai21.j2-mid-v1")
   .withPrompt("When Christmas is celebrated?")
   .build();
```

And for `Anthropic Claude V2` FM:

```java
String bedrockBody = BedrockRequestBody.builder()
   .withModelId("anthropic.claude-v2")
   .withPrompt("When Christmas is celebrated?")
   .build();
```

This approach simplifies interactions with Amazon Bedrock's API.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue