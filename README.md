# Spring AI 学习项目

这是一个使用 Spring Boot 结合 Spring AI 的示例项目，学习如何在 Spring Boot 应用中集成和使用大语言模型。

## 项目结构

```
learn-spring-ai/
├── demo1-ai-chat             # 简单/流式智能对话
├── demo2-ai-role             # 角色预设
├── demo3-ai-text2image       # 文生图
├── demo4-ai-image2text       # 图转文
├── demo5-ai-text2audio       # 文生语音
├── demo6-ai-audio2text       # 语音翻译
├── demo7-ai-multi            # 多模态
├── demo8-ai-function-call    # Function call
├── pom.xml
└── README.md
```

## 技术栈

- Java 17
- Spring Boot 3.3.9
- Spring AI BOM 1.0.0-M6
- Ollama 0.5.7

## 前置条件

- JDK 17 或更高版本
- Maven 3.6 或更高版本
- 本地 ollama 启动相关大模型

## 注意事项

1. 请确保在使用前设置正确的 API Key
2. 根据需要选择合适的模型版本
3. API Key 不要直接硬编码在代码中，建议使用环境变量注入

## Ollama

Ollama 是一个本地的、可扩展的、可部署的、可托管的大语言模型服务器。

### 怎么查看 Ollama 里面启动了那些模型？

```bash
ollama list
```

### 怎么查看 Ollama 启动的模型 BASE_URL 和 API_KEY 分别是多少？

对于Ollama的本地部署，默认配置如下：

1. Base URL: http://localhost:11434
    - 这是Ollama API的默认地址
    - 如果你在本地运行Ollama，它会监听11434端口

2. API Key:
   - Ollama本地部署默认不需要API Key
   - 它是开源的本地运行模型，不像OpenAI或通义千问那样需要认证密钥

你可以通过以下方式验证Ollama是否正在运行：

```bash
curl http://localhost:11434/api/tags
```

## 贡献指南

欢迎提交 Issue 和 Pull Request 来帮助改进项目。

## 许可证

本项目采用 MIT 许可证。 