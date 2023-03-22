import {NavigationProp} from '@react-navigation/native';

export enum RouteName {
  Home = '홈',
  SaveLiquor = '저장',
  LiquorInfo = '주류 상세정보',
  SaveReview = '리뷰 저장',
}

export type AppRouteParams = Record<RouteName, unknown>;

export type AppNavigationProp = NavigationProp<AppRouteParams>;
