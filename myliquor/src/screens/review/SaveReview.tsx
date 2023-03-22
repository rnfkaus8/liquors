import React from 'react';
import {useRoute} from '@react-navigation/native';
import {SaveReviewProps} from './useNavigateToSaveReview';

const SaveReview: React.FC = () => {
	const route = useRoute();
  const {liquorId} = route.params as SaveReviewProps;
  return <></>;
};

export default SaveReview;
