import React, {useCallback, useEffect, useState} from 'react';
import {useRoute} from '@react-navigation/native';
import {LiquorProps} from './useNavigateToLiquorInfo';
import axios from 'axios';
import {Liquor} from '../../model/Liquor';
import {Text, View} from 'react-native';

const LiquorInfo: React.FC = () => {
  const route = useRoute();
  const {liquorId} = route.params as LiquorProps;

  const [data, setData] = useState<Liquor>();

  const fetchLiquor = useCallback(async () => {
    try {
      const response = await axios.get<Liquor>(
        `http://127.0.0.1:8080/liquor/${liquorId}`,
      );
      console.log(response.data);
      setData(response.data);
    } catch (err) {
      if (err instanceof Error) {
        console.log(err.message);
      }
    }
  }, []);

  useEffect(() => {
    fetchLiquor();
  }, [fetchLiquor]);

  return (
    <View>
      <Text>카테고리 : {data?.categoryName}</Text>
      <Text>주류 명 : {data?.name}</Text>
    </View>
  );
};

export default LiquorInfo;
