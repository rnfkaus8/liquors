import {useCallback} from 'react';
import {useNavigation} from '@react-navigation/native';
import {AppNavigationProp, RouteName} from '../../asset/navigation';

export interface LiquorProps {
  liquorId: number;
}
export const useNavigateToLiquorInfo = () => {
  const navigation = useNavigation<AppNavigationProp>();
  return useCallback(
		({liquorId}: LiquorProps) => {
			navigation.navigate(RouteName.LiquorInfo, {liquorId});
		},
		[navigation],
	);
};
