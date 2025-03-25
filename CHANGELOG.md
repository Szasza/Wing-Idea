<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Wing-Idea Changelog

## [Unreleased]

### Fixed

- Windows Wing binary handling

## [0.3.0] - 2025-03-02

### Changed

- Plugged in the Wing language server
- Updated the language reference
- Updated JFlex to 1.9.2

## [0.2.0] - 2025-02-04

### Changed

- Upgraded gradle-intellij-plugin to v2
- Upgraded annotations to v26.0.2
- Upgraded qodana to v2024.3.4
- Upgraded Gradle to v8.12
- Added jUnit as test dependency

### Fixed

- Wing language server startup command generation
- Wing language server response parsing

## [0.1.6] - 2024-04-09

### Fixed

- Support IntelliJ 2024.1, EAP

## [0.1.5] - 2023-12-11

### Fixed

- Fixed structs not working
- Updated deprecated methods in LSP API
- Fixed pub and protected accessor support
- Fixed init keyword replaced with new

### Added

- Added support for Stopping and starting the Wing Console

### Changed

- Changed color scheme for editor

## [0.1.0] - 2023-08-13

### Added

- Added folding support for blocks
- Added folding support for imports
- Added support for trailing comma
- Make it explicitly not require restart for install
- Added `as` support on `new`
- Added `in` support on `new`
- Added `as` support on `bring`
- Added coloring for semicolon
- Added support for explorer window

## [0.0.2] - 2023-07-27

### Added

- Added support for caret position in arguments
- Added brace matching support
- Added commenter support
- Added quote handler
- Added plugin logo

### Fixed

- Fixed argument with argument name not being parsed correctly

## [0.0.1] - 2023-07-25

### Added

- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)

[Unreleased]: https://github.com/Szasza/Wing-Idea/compare/v0.3.0...HEAD
[0.3.0]: https://github.com/Szasza/Wing-Idea/compare/v0.2.0...v0.3.0
[0.2.0]: https://github.com/Szasza/Wing-Idea/compare/v0.1.6...v0.2.0
[0.1.6]: https://github.com/Szasza/Wing-Idea/compare/v0.1.5...v0.1.6
[0.1.5]: https://github.com/Szasza/Wing-Idea/compare/v0.1.0...v0.1.5
[0.1.0]: https://github.com/Szasza/Wing-Idea/compare/v0.0.2...v0.1.0
[0.0.2]: https://github.com/Szasza/Wing-Idea/compare/v0.0.1...v0.0.2
[0.0.1]: https://github.com/Szasza/Wing-Idea/commits/v0.0.1
