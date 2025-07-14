# 🎨 Ghibli-Style AI Image Generator

A Spring Boot backend service that uses **Stability AI's API** to generate anime-style images in the style of Studio Ghibli. Built with clean architecture and integrated using **Spring Cloud OpenFeign** for simple and declarative API communication.

## 💡 Features

- 🔠 **Text-to-Image Generation**: Input a prompt, receive an image.
- 🖼️ **Image-to-Image Transformation**: Enhance or transform your existing image with AI using a guiding prompt.
- 🌐 **Feign Client Integration**: Clean and declarative HTTP API calls using Spring Cloud OpenFeign.
- 🧩 **Pluggable Styles**: Customize style presets like `anime`, `enhance`, and more.

> ⚠️ **Note**: The image quality may not be perfect as this project uses the **free tier** of Stability AI’s API, which has limitations compared to the premium version.

---

## 📷 Example Output

| Input Prompt                                             | Output (Sample) |
|-------------------------------------------------------|--------------------------------------------------|
| `{
  "prompt": "a magical spirit in a bamboo forest",
  "style": "anime"
} `                                                     | ![Sample](.sample/response.png)                  |

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Cloud OpenFeign
- Stability AI API
- Maven

---

