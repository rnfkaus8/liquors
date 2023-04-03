import React, {useCallback, useEffect, useState} from 'react';
import {Alert, View} from 'react-native';
import axios from 'axios';
import {Button, TextInput} from 'react-native-paper';
import {SelectList} from 'react-native-dropdown-select-list/index';
import TapRating from 'react-native-ratings/dist/TapRating';
import {Category} from '../../model/Category';
import {useNavigateToLiquorInfo} from './useNavigateToLiquorInfo';

interface SeleteListData {
  key: number;
  value: string;
}
const SaveLiquor: React.FC = () => {
  const [selectListData, setSelectListData] = useState<SeleteListData[] | null>(
    null,
  );
  const [checkedCategoryId, setCheckedCategoryId] = useState<number>();

  const [liquorName, setLiquorName] = useState<string>('');
  const [priceText, setPriceText] = useState<string>('');
  const [price, setPrice] = useState<number | undefined>();
  const [rating, setRating] = useState(1);

  const navigateToLiquorInfo = useNavigateToLiquorInfo();

  const fetchCategories = useCallback(async () => {
    try {
      const response = await axios.get<Category[]>(
        'http://127.0.0.1:8080/categories',
      );

      if (response.data.length > 0) {
        const result: SeleteListData[] = [];

        response.data.forEach((category) => {
          result.push({
            key: category.id,
            value: category.name,
          });
        });

        setSelectListData(result);
      }
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

  const handleChangePrice = useCallback((text: string) => {
    const regExp = /[^0-9]/g;
    const isString = regExp.test(text);

    if (text && isString) {
      Alert.alert('잘못된 입력', '숫자만 입력하실 수 있습니다');
      setPriceText('');
      return;
    }

    setPriceText(text);
    setPrice(text !== undefined ? parseInt(text, 10) : undefined);
  }, []);

  const handlePressSubmit = useCallback(async () => {
    const axiosResponse = await axios.post<number>(
      'http://127.0.0.1:8080/liquor',
      {
        name: liquorName,
        categoryId: checkedCategoryId,
        price,
        rating,
      },
    );
    navigateToLiquorInfo({liquorId: axiosResponse.data});
  }, [liquorName, checkedCategoryId, price, rating, navigateToLiquorInfo]);

  const handleFinishRating = useCallback((val: number) => {
    setRating(val);
  }, []);

  return (
    <View>
      <TextInput
        placeholder="주류명 적으시오"
        value={liquorName}
        onChangeText={setLiquorName}
      />
      <TextInput
        placeholder="가격"
        keyboardType="numeric"
        value={priceText}
        onChangeText={handleChangePrice}
      />
      {selectListData && (
        <SelectList
          setSelected={(val: number) => {
            setCheckedCategoryId(val);
          }}
          data={selectListData}
          save="key"
        />
      )}

      <TapRating onFinishRating={handleFinishRating} />

      <Button mode="contained" onPress={handlePressSubmit}>
        저장하기
      </Button>
    </View>
  );
};

export default SaveLiquor;
