import {useCallback} from 'react';
import {useNavigation} from '@react-navigation/native';
import {AppNavigationProp, RouteName} from '../../asset/navigation';

export const useNavigateToHome = () => {
  const navigation = useNavigation<AppNavigationProp>();
  return useCallback(() => {
    navigation.navigate(RouteName.Home, {});
  }, [navigation]);
};
