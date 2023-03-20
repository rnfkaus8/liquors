import React, {useCallback} from 'react';
import {Button, Text, View} from 'react-native';
import {useNavigation} from '@react-navigation/native';
import {AppNavigationProp, RouteName} from '../asset/navigation';

const Home: React.FC = () => {
  const navigation = useNavigation<AppNavigationProp>();

  const handlePressNavigateToSaveLiquor = useCallback(
    () => navigation.navigate(RouteName.SaveLiquor),
    [],
  );

  return (
    <View>
      <Text>홈 화면</Text>
      <Text>
        내가 추가한 주류가 아무것도 없다면 추가 버튼이 홈 중앙에 위치되어야
        합니다
      </Text>
      <Button
        title="주류 추가 페이지 이동"
        onPress={handlePressNavigateToSaveLiquor}
      />
    </View>
  );
};

export default Home;
