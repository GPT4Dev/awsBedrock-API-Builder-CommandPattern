# Amazon Bedrock API with Builder and Command Patterns

[Amazon Bedrock](https://aws.amazon.com/bedrock) offers choice of high-performing foundation models from leading AI companies like AI21 Labs, Anthropic, Cohere, Stability AI, and Amazon through a single API. Despite the uniform API, each foundation model has its unique schema, making API interactions complex for developers.

For instance, let's consider the prompt: `When Christmas is celebrated?`

Making API requests to Amazon Bedrock using different foundation models would require distinct body payloads.

This project offers a simple yet powerful implementation to efficiently handle such API interactions. It utilizes the [Builder design pattern](https://en.wikipedia.org/wiki/Builder_pattern) and the [Com