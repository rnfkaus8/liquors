import React, {useCallback, useEffect, useState} from 'react';
import {Text, View} from 'react-native';
import axios from 'axios';

interface Category {
  id: number;
  name: string;
}

const SaveLiquor: React.FC = () => {
  const [categories, setCategories] = useState<Category[]>();

  const fetchCategories = useCallback(async () => {
    try {
      const response = await axios.get<Category[]>(
        `http://127.0.0.1:8080/categories`,
      );

      setCategories(response.data);
    } catch (err) {
      if (err instanceof Error) {
        console.log(err.message);
        console.log(err.stack);
      }
    }
  }, []);

  useEffect(() => {
    fetchCategories();
  }, []);

  return (
    <View>
      <Text>내가 마신 주류를 저장하는 페이지입니당</Text>
      {categories &&
        categories.map((category) => {
          return (
            <View key={category.id}>
              <Text>{category.name}</Text>
            </View>
          );
        })}
    </View>
  );
};

export default SaveLiquor;
