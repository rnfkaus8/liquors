import React, {useCallback, useEffect, useState} from 'react';
import {Button, Text, View} from 'react-native';
import {useFocusEffect, useNavigation} from '@react-navigation/native';
import {AppNavigationProp, RouteName} from '../../asset/navigation';
import axios from 'axios';
import {Liquor} from '../../model/Liquor';

const Home: React.FC = () => {
  const navigation = useNavigation<AppNavigationProp>();
  const [liquors, setLiquors] = useState<Liquor[] | null>();

  const handlePressNavigateToSaveLiquor = useCallback(() => {
    navigation.navigate(RouteName.SaveLiquor);
  }, [navigation]);

  const fetchLiquors = useCallback(async () => {
    try {
      const response = await axios.get<Liquor[]>(
        'http://127.0.0.1:8080/liquors',
      );

      if (response.data.length > 0) {
        setLiquors(response.data);
      }
    } catch (err) {
      console.log(err);
    }
  }, []);

  useFocusEffect(
    useCallback(() => {
      fetchLiquors();
    }, [fetchLiquors]),
  );

  return (
    <View>
      {liquors &&
        liquors.length > 0 &&
        liquors.map((liquor) => {
          return (
            <View key={liquor.id} style={{borderBottomWidth: 1}}>
              <Text>{liquor.name}</Text>
              <Text>{liquor.category.name}</Text>
            </View>
          );
        })}
      <View style={{height: 25}} />
      <Button
        title="주류 추가 페이지 이동"
        onPress={handlePressNavigateToSaveLiquor}
      />
    </View>
  );
};

export default Home;
