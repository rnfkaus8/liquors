import React, {useCallback, useState} from 'react';
import {useRoute} from '@react-navigation/native';
import {Button, Image, View} from 'react-native';
import {launchCamera, launchImageLibrary} from 'react-native-image-picker';
import axios from 'axios';
import {SaveReviewProps} from './useNavigateToSaveReview';

const SaveReview: React.FC = () => {
  const route = useRoute();
  const {liquorId} = route.params as SaveReviewProps;

  const [imageUri, setImageUri] = useState<string>();

  const handlePressImageLibrary = useCallback(async () => {
    const pickedImage = await launchImageLibrary({
      mediaType: 'photo',
      selectionLimit: 1,
    });

    if (pickedImage.didCancel) {
      return;
    }

    const {assets} = pickedImage;
    if (!assets) {
      return;
    }

    const {uri, fileName} = assets[0];
    if (!uri || !fileName) {
      return;
    }

    const formData = new FormData();
    formData.append('image', {type: 'image/jpg', uri, name});

    setImageUri(uri);

    axios.post();
  }, []);

  const handlePressCamara = useCallback(async () => {
    const result = await launchCamera({mediaType: 'photo'});

    const {assets} = result;
    if (!assets) {
      return;
    }
    const {uri, fileName} = assets[0];

    console.log(uri);
    console.log(fileName);
  }, []);

  return (
    <View>
      <Button
        title="이미지 라이브러리에서 고르기"
        onPress={handlePressImageLibrary}
      >
        이미지 로드 버튼
      </Button>
      <Button title="카메라로 사진 촬영하기" onPress={handlePressCamara}>
        이미지 로드 버튼
      </Button>
      <Image source={{uri: imageUri}} />
    </View>
  );
};

export default SaveReview;
