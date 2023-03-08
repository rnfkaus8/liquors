import {NavigationProp} from '@react-navigation/native';

export enum RouteName {
  Liquor = '홈',
  SaveLiquor = '저장',
}

export type AppRouteParams = Record<RouteName, unknown>;

export type AppNavigationProp = NavigationProp<AppRouteParams>;
