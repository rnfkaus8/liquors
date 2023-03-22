import {useCallback} from 'react';
import {useNavigation} from '@react-navigation/native';
import {AppNavigationProp, RouteName} from '../../asset/navigation';

export interface SaveReviewProps {
  liquorId: number;
}
export const useNavigateToLiquorInfo = () => {
	const navigation = useNavigation<AppNavigationProp>();
	return useCallback(
		({liquorId}: SaveReviewProps) => {
			navigation.navigate(RouteName.SaveReview, {liquorId});
		},
		[navigation],
	);
};
