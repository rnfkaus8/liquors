import React, {useCallback, useEffect, useState} from 'react';
import {useRoute} from '@react-navigation/native';
import axios from 'axios';
import {Text, View} from 'react-native';
import {Button} from 'react-native-paper';
import {LiquorProps} from './useNavigateToLiquorInfo';
import {Liquor} from '../../model/Liquor';
import {useNavigateToSaveReview} from '../review/useNavigateToSaveReview';

const LiquorInfo: React.FC = () => {
  const route = useRoute();
  const {liquorId} = route.params as LiquorProps;

  const navigateToSaveReview = useNavigateToSaveReview();

  const [data, setData] = useState<Liquor>();

  const fetchLiquor = useCallback(async () => {
    try {
      const response = await axios.get<Liquor>(
        `http://127.0.0.1:8080/liquor/${liquorId}`,
      );
      setData(response.data);
    } catch (err) {
      if (err instanceof Error) {
        console.log(err.message);
      }
    }
  }, [liquorId]);

  useEffect(() => {
    fetchLiquor();
  }, [fetchLiquor]);

  const handlePressNavigateToSaveReview = useCallback(() => {
    navigateToSaveReview({liquorId});
  }, [liquorId, navigateToSaveReview]);

  return (
    <View>
      <Text>카테고리 : {data?.category.name}</Text>
      <Text>주류 명 : {data?.name}</Text>
      <Button mode="contained" onPress={handlePressNavigateToSaveReview}>
        리뷰 추가
      </Button>
    </View>
  );
};

export default LiquorInfo;
