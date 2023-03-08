import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Liquor from './screens/Liquor';
import SaveLiquor from './screens/SaveLiquor';
import {RouteName} from './asset/navigation';

const Stack = createNativeStackNavigator();
const App: React.FC = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name={RouteName.Liquor} component={Liquor} />
        <Stack.Screen name={RouteName.SaveLiquor} component={SaveLiquor} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
