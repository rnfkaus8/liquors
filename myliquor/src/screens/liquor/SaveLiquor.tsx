import React, {useCallback, useEffect, useState} from 'react';
import {Text, View} from 'react-native';
import axios from 'axios';
import {Button, RadioButton, TextInput} from 'react-native-paper';
import {Category} from '../../model/Category';
import {useNavigateToLiquorInfo} from './useNavigateToLiquorInfo';

const SaveLiquor: React.FC = () => {
  const [categories, setCategories] = useState<Category[]>();
  const [checkedCategoryId, setCheckedCategoryId] = useState<number>();

  const [liquorName, setLiquorName] = useState<string>('');

  const navigateToLiquorInfo = useNavigateToLiquorInfo();

  const fetchCategories = useCallback(async () => {
    try {
      const response = await axios.get<Category[]>(
        'http://127.0.0.1:8080/categories',
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
  }, [fetchCategories]);

  const handlePressSubmit = useCallback(async () => {
    const axiosResponse = await axios.post<number>(
      'http://127.0.0.1:8080/liquor',
      {
        name: liquorName,
        categoryId: checkedCategoryId,
      },
    );
    navigateToLiquorInfo({liquorId: axiosResponse.data});
  }, [liquorName, checkedCategoryId, navigateToLiquorInfo]);

  return (
    <View>
      <TextInput
        placeholder="주류명 적으시오"
        value={liquorName}
        onChangeText={setLiquorName}
      />
      {categories &&
        categories.map((category) => {
          return (
            <View
              key={category.id}
              style={{flexDirection: 'row', alignItems: 'center'}}
            >
              <RadioButton
                value={category.name}
                status={
                  checkedCategoryId === category.id ? 'checked' : 'unchecked'
                }
                onPress={() => {
                  setCheckedCategoryId(category.id);
                }}
              />
              <Text>{category.name}</Text>
            </View>
          );
        })}
      <Button mode="contained" onPress={handlePressSubmit}>
        저장하기
      </Button>
    </View>
  );
};

export default SaveLiquor;
