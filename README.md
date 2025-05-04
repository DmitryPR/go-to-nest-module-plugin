# Go To NestJS Module

A lightweight JetBrains plugin for quickly navigating to NestJS module files in your project by typing the module name.

---

## ✨ Features

- Input a module name (e.g. `user`)
- Jumps to `user.module.ts` inside `/src/modules/`
- Supports WebStorm and other IntelliJ-based IDEs

---

## 🔧 Installation

1. Clone this repo:
   ```bash
   git clone https://github.com/dmitrypr/go-to-nest-module-plugin.git
   cd go-to-nest-module-plugin
   ```

2. Open in **IntelliJ IDEA (Community Edition)**

3. Build the plugin with terminal or run from intellij:
   ```bash
   ./gradlew buildPlugin
   ```

4. Go to `build/distributions/` and install the generated `.zip` file in WebStorm:
    - **Preferences → Plugins → ⚙ → Install Plugin from Disk**

---

## 🛠️ Development Notes

- Target IntelliJ Platform SDK: `2023.2` or newer
- Kotlin 1.9.10
- JVM Target: `17`
- Gradle 8.2+

---

## 📄 License

MIT — feel free to fork, contribute, or suggest features!
