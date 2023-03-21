import {Category} from './Category';

export class Liquor {
  private readonly _id: number;
  private readonly _name: string;
  private readonly _categoryId: number;
  private readonly _categoryName: string;

  constructor(
    id: number,
    name: string,
    categoryId: number,
    categoryName: string,
  ) {
    this._id = id;
    this._name = name;
    // TODO Category 모델을 참조하게 바꿀 필요가 있어보인다.
    this._categoryId = categoryId;
    this._categoryName = categoryName;
  }

  get id(): number {
    return this._id;
  }

  get name(): string {
    return this._name;
  }

  get categoryId(): number {
    return this._categoryId;
  }

  get categoryName(): string {
    return this._categoryName;
  }
}
