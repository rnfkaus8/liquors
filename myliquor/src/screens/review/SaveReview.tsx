import React, {useCallback} from 'react';
import {useRoute} from '@react-navigation/native';
import {Button, View} from 'react-native';
import {launchImageLibrary} from 'react-native-image-picker';
import {SaveReviewProps} from './useNavigateToSaveReview';

const SaveReview: React.FC = () => {
  const route = useRoute();
  const {liquorId} = route.params as SaveReviewProps;

  const handlePressImageLibrary = useCallback(() => {
    launchImageLibrary({mediaType: 'photo', selectionLimit: 1}).then((val) => {
      return console.log(val);
    });
  }, []);

  return (
    <View>
      <Button title="hihihihihi" onPress={handlePressImageLibrary}>
        이미지 로드 버튼
      </Button>
    </View>
  );
};

export default SaveReview;
