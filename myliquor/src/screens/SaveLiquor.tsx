import React, {useCallback, useEffect} from 'react';
import {Text, View} from 'react-native';
import axios from 'axios';

interface Category {
  id: number;
  name: string;
}

const SaveLiquor: React.FC = () => {
  const fetchCategories = useCallback(async () => {
    try {
      const response = await axios.get<Category[]>(
        `http://127.0.0.1:8080/categories`,
      );

      console.log('status', response.status);
      console.log('data', response.data);
    } catch (err) {
      if (err instanceof Error) {
        console.log(err.message);
        console.log(err.stack);
      }
    }
  }, []);

  useEffect(() => {
    console.log('hi');
    fetchCategories();
  }, [fetchCategories]);
  return (
    <View>
      <Text>내가 마신 주류를 저장하는 페이지입니당</Text>
    </View>
  );
};

export default SaveLiquor;
