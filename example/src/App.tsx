import * as React from 'react';
import { StyleSheet, View, Text, TouchableOpacity } from 'react-native';
import { allow, forbid } from 'react-native-secure-screen';

export default function App() {
  React.useEffect(() => {
    forbid();
  }, []);

  return (
    <View style={styles.container}>
      <TouchableOpacity onPress={allow} style={styles.button}>
        <Text style={styles.buttonText}>Allow Screenshots</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={forbid} style={styles.button}>
        <Text style={styles.buttonText}>Block Screenshots</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  button: {
    paddingVertical: 10,
    paddingHorizontal: 30,
    borderRadius: 4,
    marginBottom: 20,
    backgroundColor: '#942560',
  },
  buttonText: {
    color: '#FFF',
  },
});
