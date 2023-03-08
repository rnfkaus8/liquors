import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Liquor from './screens/Liquor';

const Stack = createNativeStackNavigator();
const App: React.FC = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Liquor" component={Liquor} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
