# React Native Secure Screen

Prevent screenshot in JS runtime. **Android only**

## Installation

```sh
# npm users
npm install react-native-secure-screen

# yarn users
yarn add react-native-secure-screen
```

## Usage

```js
import { allow, forbid } from "react-native-secure-screen";

// Set Security Mode
await forbid();

// Clear Security Mode
await allow();
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
