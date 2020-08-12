import { NativeModules, Platform } from 'react-native';

type SecureScreenType = {
  /**
   * Set Secure Mode flag
   */
  forbid(): Promise<void>;
  /**
   * Clear Secure Mode flag
   */
  allow(): Promise<void>;
};

const SecureScreen = NativeModules.RNSecureScreen as SecureScreenType;

async function forbid() {
  if (Platform.OS === 'android') {
    await SecureScreen.forbid();
  }
}

async function allow() {
  if (Platform.OS === 'android') {
    await SecureScreen.allow();
  }
}

export { forbid, allow };
