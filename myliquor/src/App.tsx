import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Home from './screens/Home';
import SaveLiquor from './screens/SaveLiquor';
import {RouteName} from './asset/navigation';

const Stack = createNativeStackNavigator();
const App: React.FC = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name={RouteName.Liquor} component={Home} />
        <Stack.Screen name={RouteName.SaveLiquor} component={SaveLiquor} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
