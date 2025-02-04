# Wing-Idea

![Build](https://github.com/Szasza/Wing-Idea/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/22353.svg)](https://plugins.jetbrains.com/plugin/22353)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/22353.svg)](https://plugins.jetbrains.com/plugin/22353)

This plugin adds supports for Wing language in IntelliJ IDE's. It is not affiliated with either Wing or JetBrains.

<!-- Plugin description -->
Adds support for the Wing language.  
  
Wing combines infrastructure and runtime code in one language, enabling developers to stay in their creative flow,
and to deliver better software, faster and more securely.


The following features are supported:
- Syntax highlighting
- LSP support
- Wing Console browser window

<!-- Plugin description end -->

## Prerequisites

1. [Install NodeJS](https://nodejs.org/en/download)
2. [Install Wing](https://www.winglang.io/install)
3. [Install IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/download/)
4. [Configure the Node.js interpreter in IDEA](https://www.jetbrains.com/help/idea/developing-node-js-applications.html#ws_node_configure_local_node_interpreter)

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Wing"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/Szasza/Wing-Idea/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
