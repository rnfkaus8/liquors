import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Home from './screens/Home';
import SaveLiquor from './screens/liquor/SaveLiquor';
import {RouteName} from './asset/navigation';
import LiquorInfo from './screens/liquor/LiquorInfo';

const Stack = createNativeStackNavigator();
const App: React.FC = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name={RouteName.Home} component={Home} />
        <Stack.Screen name={RouteName.SaveLiquor} component={SaveLiquor} />
        <Stack.Screen name={RouteName.LiquorInfo} component={LiquorInfo} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
