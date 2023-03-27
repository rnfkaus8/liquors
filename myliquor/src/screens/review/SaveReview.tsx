import React from 'react';
import {useRoute} from '@react-navigation/native';
import { Button, View } from 'react-native';
import {SaveReviewProps} from './useNavigateToSaveReview';
import { launchImageLibrary } from "react-native-image-picker";

const SaveReview: React.FC = () => {
  const route = useRoute();
  const {liquorId} = route.params as SaveReviewProps;

  return <View>
		<Button title='hihihihihi' onPress={async () => {
			await launchImageLibrary();
		}
		}
	</View>;
};

export default SaveReview;
